package com.wl.padroes_de_projeto_spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoRequestDTO(

        @NotBlank(message = "CEP não pode ser vazio ou apenas espaços em branco")
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve estar no formato 00000-000")
        String cep
) {}
