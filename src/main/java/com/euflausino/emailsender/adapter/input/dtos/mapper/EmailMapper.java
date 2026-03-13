package com.euflausino.emailsender.adapter.input.dtos.mapper;

import com.euflausino.emailsender.adapter.input.dtos.EmailRequestDTO;
import com.euflausino.emailsender.adapter.input.dtos.OthersEmailRequestDTO;
import com.euflausino.emailsender.aplication.entity.EmailEntity;
import com.euflausino.emailsender.aplication.entity.EmailOtherEntity;

public class EmailMapper {

    public static EmailEntity toEmailEntity(EmailRequestDTO emailRequestDTO) {
        return new EmailEntity(
                emailRequestDTO.email(),
                emailRequestDTO.assunto(),
                emailRequestDTO.mensagem()
        );
    }

    public static EmailOtherEntity toEmailOtherEntity(OthersEmailRequestDTO emailRequestDTO) {
        return new EmailOtherEntity(
                emailRequestDTO.email(),
                emailRequestDTO.assunto(),
                emailRequestDTO.mensagem()
        );
    }

}
