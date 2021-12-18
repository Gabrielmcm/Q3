package main.java.com.clientes.clientes.Service;

import java.util.List;
import java.util.Optional;

import com.clientes.musica.model.CLiente;
import com.clientes.musica.shared.ClienteDTO;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    List<ClienteDTO> obterTodos();

    Optional<ClienteDTO> obterPorId(String idCliente);

    ClienteDTO adicionar(ClienteDTO clienteDto);

    Cliente atualizar(String idCliente, ClienteDTO clienteDto);

    void delete(String idCliente);
}
