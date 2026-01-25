package com.euflausino.emailsender.adapter.input.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailRequestDTO(
        @NotBlank(message = "Email obrigatório!")
        @Email(message = "Email inváalido!")
        String email,
        String assunto,
        String mensagem
) {
}
