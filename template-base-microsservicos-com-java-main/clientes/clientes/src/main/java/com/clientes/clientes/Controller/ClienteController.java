package main.java.com.clientes.clientes.Controller;

import java.util.List;
import java.util.Optional;

import com.clientes.cliente.model.Cliente;
import com.clientes.cliente.service.ClienteService;
import com.clientes.cliente.shared.ClienteDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    @Autowired
    ClienteService servicoCliente;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> obterTodos(){
        List<ClienteDTO> clientes = servicoCliente.obterTodos();

        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClienteDTO>> obterPorId(@PathVariable String id){
        Optional<ClienteDTO> Cliente = servicoCliente.obterPorId(id);
        
        return new ResponseEntity<>(Cliente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> adicionar(@RequestBody ClienteDTO ClienteDTO){
    ClienteDTO = servicoCliente.adicionar(ClienteDTO);

        return new ResponseEntity<>(ClienteDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar (@PathVariable String id, 
    @RequestBody ClienteDTO ClienteDTO){

        return new ResponseEntity<>(servicoCliente.atualizar(id, ClienteDTO), HttpStatus.OK);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id){
        servicoCliente.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

}
