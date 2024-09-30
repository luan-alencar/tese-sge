package com.backend.sge.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "pergunta")
public class Pergunta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pergunta")
    @SequenceGenerator(name = "sq_pergunta", allocationSize = 1, sequenceName = "sq_pergunta")
    @Column(name = "id")
    private Integer id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "obrigatoria")
    private Boolean obrigatoria;

}