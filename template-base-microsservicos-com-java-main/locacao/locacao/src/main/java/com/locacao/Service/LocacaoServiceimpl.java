package main.java.com.locacao.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.locacoes.locacao.model.Locacao;
import com.locacoes.locacao.repository.LocacaoRepository;
import com.locacoes.locacao.shared.LocacaoDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class LocacaoServiceImpl implements LocacaoService {

    @Autowired
    LocacaoRepository repositorioLocacao;

    @Override
    public List<LocacaoDTO> obterTodos() {
        List<Locacao> Locacaos = repositorioLocacao.findAll();
        ModelMapper mapper = new ModelMapper();

        return Locacaos.stream()
        .map(locacao -> mapper.map(locacao, LocacaoDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public Optional<LocacaoDTO> obterPorId(String idLocacao) {
        Optional<Locacao> optionalLocacao = repositorioLocacao.findById(idLocacao);
        if(optionalLocacao.isEmpty()){
            throw new InputMismatchException("Música não encontrada." + idLocacao);
        }
        LocacaoDTO LocacaoDTO = new ModelMapper().map(optionalLocacao.get(), LocacaoDTO.class);

        return Optional.of(LocacaoDTO);
    }

    @Override
    public LocacaoDTO adicionar(LocacaoDTO locacaoDto) {
        ModelMapper mapper = new ModelMapper();
        Locacao locacao = mapper.map(locacaoDto, Locacao.class);
        locacao.setId(null);
        locacao = repositorioLocacao.save(locacao);

        return mapper.map(locacao, locacaoDto.class);
    }

    @Override
    public Locacao atualizar(String idLocacao, locacaoDto locacaoDto){
        if(repositorioLocacao.findById(idLocacao).isPresent()){
            Locacao locacaoAtt = repositorioLocacao.findById(idLocacao).get(); 

           locacaoAtt.setTitulo(locacaoDto.getTitulo());
           locacaoAtt.setArtista(locacaoDto.getArtista());
           locacaoAtt.setAlbum(locacaoDto.getAlbum());
           locacaoAtt.setGenero(locacaoDto.getGenero());
           locacaoAtt.setAnoDoLancamento(locacaoDto.getAnoDoLancamento());
           locacaoAtt.setCompositor(locacaoDto.getCompositor());

            return repositorioLocacao.save(locacaoAtt);
        }else{
            throw new InputMismatchException("Impossível de Atualizar");
        }
    }

    @Override
    public void delete(String idLocacao) {
        repositorioLocacao.deleteById(idLocacao);
        
    }
}
    

