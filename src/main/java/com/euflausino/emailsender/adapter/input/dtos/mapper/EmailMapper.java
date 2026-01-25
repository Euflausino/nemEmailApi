package com.euflausino.emailsender.adapter.input.dtos.mapper;

import com.euflausino.emailsender.adapter.input.dtos.EmailRequestDTO;
import com.euflausino.emailsender.aplication.entity.EmailEntity;

public class EmailMapper {

    public static EmailEntity toEmailEntity(EmailRequestDTO emailRequestDTO) {
        return new EmailEntity(
                emailRequestDTO.email(),
                emailRequestDTO.assunto(),
                emailRequestDTO.mensagem()
        );
    }

}
