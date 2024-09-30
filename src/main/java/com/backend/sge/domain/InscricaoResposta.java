package com.backend.sge.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inscricao_resposta")
@Data
public class InscricaoResposta {


    @EmbeddedId
    private InscricaoRespostaId id;

    @Column(name = "resposta")
    private String resposta;

    @MapsId("idInscricao")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inscricao")
    private Inscricao inscricao;

    @MapsId("idEvento")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @MapsId("idPergunta")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pergunta")
    private Pergunta pergunta;

}