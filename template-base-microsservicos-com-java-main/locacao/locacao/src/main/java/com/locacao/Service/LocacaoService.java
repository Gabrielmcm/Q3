package main.java.com.locacao.Service;

import java.util.List;
import java.util.Optional;

import com.locacoes.musica.model.CLiente;
import com.locacoes.musica.shared.LocacaoDTO;

import org.springframework.stereotype.Service;

@Service
public class LocacaoService {
    List<LocacaoDTO> obterTodos();

    Optional<LocacaoDTO> obterPorId(String idLocacao);

    LocacaoDTO adicionar(LocacaoDTO locacaoDto);

    Locacao atualizar(String idLocacao, LocacaoDTO locacaoDto);

    void delete(String idLocacao);
}