package br.com.api.servico.servico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.servico.modelo.RespostaModelo;
import br.com.api.servico.modelo.ServicoModelo;
import br.com.api.servico.repositorio.ServicoRepositorio;

@Service
public class ServicoService {
    
    @Autowired
    private ServicoRepositorio sr;

    @Autowired
    private RespostaModelo rm;

    public Iterable<ServicoModelo> listar(){
        return sr.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(ServicoModelo sm, String acao){

        if(sm.getEmpresa().equals("")){
            rm.setMensagem("Nome da empresa não foi informado!");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }else if(sm.getServico().equals("")){
            rm.setMensagem("Nome do serviço não foi informado");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }else if(sm.getCategoria().equals("")){
            rm.setMensagem("Categoria de serviços não foi informada.");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(sm.getPreco().equals("")){
            rm.setMensagem("Valor do serviço não foi informado.");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<ServicoModelo>(sr.save(sm), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<ServicoModelo>(sr.save(sm), HttpStatus.OK);
            }
        }

    }

    public ResponseEntity<RespostaModelo> deletar(long id){
        sr.deleteById(id);
        rm.setMensagem("O Serviço foi deletado!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }

    

}
