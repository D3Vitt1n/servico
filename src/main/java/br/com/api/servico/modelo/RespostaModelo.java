package br.com.api.servico.modelo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class RespostaModelo {
    // Classe criada para quando ouver algum problema em requisições

    private String mensagem;
}
