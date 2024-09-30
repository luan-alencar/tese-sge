package com.backend.sge.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_evento")
    @SequenceGenerator(name = "sq_evento", allocationSize = 1, sequenceName = "sq_evento")
    @Column(name = "id")
    private Integer id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_termino")
    private LocalDateTime dataTermino;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "qt_vagas")
    private Integer qtVagas;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "local")
    private String local;

    @Column(name = "tipo_inscricao")
    private Boolean tipoInscricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_evento")
    private TipoEvento tipoEvento;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "evento")
    private List<EventoPergunta> perguntas;
}
