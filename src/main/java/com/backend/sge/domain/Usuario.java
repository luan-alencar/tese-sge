    package com.backend.sge.domain;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.io.Serializable;
    import java.time.LocalDate;

    @Entity
    @Table(name = "usuario")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Usuario implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_usuario")
        @SequenceGenerator(name = "sq_usuario", allocationSize = 1, sequenceName = "sq_usuario")
        @Column(name = "id")
        private Integer id;

        @Column(name = "nome")
        private String nome;

        @Column(name = "cpf")
        private String cpf;

        @Column(name = "email")
        private String email;

        @Column(name = "telefone")
        private String telefone;

        @Column(name = "data_nascimento")
        private LocalDate dataNascimento;

        @Column(name = "adm")
        private Boolean adm;

        @Column(name = "chave")
        private String chave;

    }
