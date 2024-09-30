package com.backend.sge.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "evento_pergunta")
@Data
public class EventoPergunta implements Serializable {

    @EmbeddedId
    private EventoPerguntaId id;

    @MapsId("idEvento")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @MapsId("idPergunta")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pergunta")
    private Pergunta pergunta;

}
