package com.backend.sge.domain.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable {

    private Integer id;

    @NotNull(message = "CPF não pode ser nulo")
    @CPF(message = "CPF Inválido")
    private String cpf;

    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @NotNull(message = "Email não pode ser nulo")
    @Email(message = "Email Inválido")
    private String email;

    @NotNull(message = "Telefone não pode ser nulo")
    @NotBlank(message = "Coloque um telefone")
    private String telefone;

    @NotNull(message = "Data de nascimento não pode ser nulo")
    private LocalDate dataNascimento;

    private Boolean adm;

}
