package com.backend.sge.domain;

import jakarta.persistence.*;
import lombok.Data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name = "tipo_evento")
@Data
public class TipoEvento implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

}
