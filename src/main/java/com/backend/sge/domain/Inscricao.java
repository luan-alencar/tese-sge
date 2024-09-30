package com.backend.sge.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "inscricao")
@Data
public class Inscricao {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_inscricao")
    @SequenceGenerator(name = "sq_inscricao", allocationSize = 1, sequenceName = "sq_inscricao")
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_situacao")
    private TipoSituacao tipoSituacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "inscricao")
    private List<InscricaoResposta> respostas;
}