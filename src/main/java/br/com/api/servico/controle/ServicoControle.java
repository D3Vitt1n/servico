package br.com.api.servico.controle;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.servico.modelo.RespostaModelo;
import br.com.api.servico.modelo.ServicoModelo;
import br.com.api.servico.servico.ServicoService;



@RestController
public class ServicoControle {

    @Autowired
    private ServicoService ss;

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<RespostaModelo> deletar(@PathVariable long id){
        return ss.deletar(id);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ServicoModelo sm){
        return ss.cadastrarAlterar(sm,"alterar");
    }       

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ServicoModelo sm){
        return ss.cadastrarAlterar(sm,"cadastrar");
    }

    @GetMapping("/listar")
    public Iterable<ServicoModelo> listar(){
        return ss.listar();
    }

    @GetMapping("/")
    public String rota(){
        return "API está funcionando!";
    }


}
