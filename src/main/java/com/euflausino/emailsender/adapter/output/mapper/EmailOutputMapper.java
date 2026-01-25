package com.euflausino.emailsender.adapter.output.mapper;

import com.euflausino.emailsender.adapter.output.EmailJPA;
import com.euflausino.emailsender.aplication.entity.EmailEntity;

public class EmailOutputMapper {

    public static EmailJPA toJPA (EmailEntity entity) {
        return new EmailJPA(
                null,
                entity.getEmail(),
                entity.getAssunto(),
                entity.getMensagem(),
                null
        );
    }

}
