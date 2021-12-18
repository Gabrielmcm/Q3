package main.java.com.locacao.Controller;

import java.util.List;
import java.util.Optional;

import com.locacao.locacao.model.Locacao;
import com.locacao.locacao.service.Locacaoervice;
import com.locacao.locacao.shared.LocacaoDTO;

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
@RequestMapping("/api/locacoes")
public class LocacaoController {
    
    @Autowired
    LocacaoService servicoLocacao;

    @GetMapping
    public ResponseEntity<List<LocacaoDTO>> obterTodos(){
        List<LocacaoDTO> locacoes = servicoLocacao.obterTodos();

        return new ResponseEntity<>(locacoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LocacaoDTO>> obterPorId(@PathVariable String id){
        Optional<LocacaoDTO> Locacao = servicoLocacao.obterPorId(id);
        
        return new ResponseEntity<>(Locacao, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LocacaoDTO> adicionar(@RequestBody LocacaoDTO LocacaoDTO){
    LocacaoDTO = servicoLocacao.adicionar(LocacaoDTO);

        return new ResponseEntity<>(LocacaoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Locacao> atualizar (@PathVariable String id, 
    @RequestBody LocacaoDTO LocacaoDTO){

        return new ResponseEntity<>(servicoLocacao.atualizar(id, LocacaoDTO), HttpStatus.OK);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id){
        servicoLocacao.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

}
