package com.backend.sge.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "tipo_situacao")
@Data
public class TipoSituacao implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

}
