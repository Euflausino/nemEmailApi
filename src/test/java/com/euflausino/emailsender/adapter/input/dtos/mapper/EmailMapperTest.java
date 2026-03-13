package com.euflausino.emailsender.adapter.input.dtos.mapper;

import com.euflausino.emailsender.adapter.input.dtos.EmailRequestDTO;
import com.euflausino.emailsender.aplication.entity.EmailEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("EmailMapper Tests")
class EmailMapperTest {

    @Test
    @DisplayName("Deve mapear EmailRequestDTO para EmailEntity")
    void deveMapearParaEmailEntity() {
        EmailRequestDTO request = new EmailRequestDTO("test@example.com", "Assunto", "Mensagem");

        EmailEntity entity = EmailMapper.toEmailEntity(request);

        assertNotNull(entity);
        assertEquals("test@example.com", entity.getEmail());
        assertEquals("Assunto", entity.getAssunto());
        assertEquals("Mensagem", entity.getMensagem());
    }
}
