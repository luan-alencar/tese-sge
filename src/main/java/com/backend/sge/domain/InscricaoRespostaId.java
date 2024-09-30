package com.backend.sge.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class InscricaoRespostaId implements Serializable {

    private Integer idEvento;
    private Integer idPergunta;
    private Integer idInscricao;
}

