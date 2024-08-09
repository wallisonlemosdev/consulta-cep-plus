package com.wl.padroes_de_projeto_spring.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteRequestDTO(
        @NotBlank(message = "Nome não pode ser vazio ou apenas espaços em branco")
        String nome,

        @Valid
        @NotNull(message = "Endereço não pode ser nulo")
        EnderecoRequestDTO endereco
) {}
