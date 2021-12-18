package main.java.com.clientes.clientes.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.clientes.cliente.model.Cliente;
import com.clientes.cliente.repository.ClienteRepository;
import com.clientes.cliente.shared.ClienteDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository repositorioCliente;

    @Override
    public List<ClienteDTO> obterTodos() {
        List<Cliente> Clientes = repositorioCliente.findAll();
        ModelMapper mapper = new ModelMapper();

        return Clientes.stream()
        .map(cliente -> mapper.map(cliente, ClienteDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteDTO> obterPorId(String idCliente) {
        Optional<Cliente> optionalCliente = repositorioCliente.findById(idCliente);
        if(optionalCliente.isEmpty()){
            throw new InputMismatchException("Música não encontrada." + idCliente);
        }
        ClienteDTO ClienteDTO = new ModelMapper().map(optionalCliente.get(), ClienteDTO.class);

        return Optional.of(ClienteDTO);
    }

    @Override
    public ClienteDTO adicionar(ClienteDTO clienteDto) {
        ModelMapper mapper = new ModelMapper();
        Cliente cliente = mapper.map(clienteDto, Cliente.class);
        cliente.setId(null);
        cliente = repositorioCliente.save(cliente);

        return mapper.map(cliente, clienteDto.class);
    }

    @Override
    public Cliente atualizar(String idCliente, clienteDto clienteDto){
        if(repositorioCliente.findById(idCliente).isPresent()){
            Cliente clienteAtt = repositorioCliente.findById(idCliente).get(); 

           clienteAtt.setTitulo(clienteDto.getTitulo());
           clienteAtt.setArtista(clienteDto.getArtista());
           clienteAtt.setAlbum(clienteDto.getAlbum());
           clienteAtt.setGenero(clienteDto.getGenero());
           clienteAtt.setAnoDoLancamento(clienteDto.getAnoDoLancamento());
           clienteAtt.setCompositor(clienteDto.getCompositor());

            return repositorioCliente.save(clienteAtt);
        }else{
            throw new InputMismatchException("Impossível de Atualizar");
        }
    }

    @Override
    public void delete(String idCliente) {
        repositorioCliente.deleteById(idCliente);
        
    }
}
    
