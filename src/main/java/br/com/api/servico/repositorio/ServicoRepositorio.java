package br.com.api.servico.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.servico.modelo.ServicoModelo;

@Repository
public interface ServicoRepositorio extends CrudRepository<ServicoModelo,Long> {
    
}
