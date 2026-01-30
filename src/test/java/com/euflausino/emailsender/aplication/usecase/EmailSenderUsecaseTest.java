package com.euflausino.emailsender.aplication.usecase;

import com.euflausino.emailsender.aplication.entity.EmailEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmailSenderUsecaseTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailSenderUsecase usecase;

    @Test
    void deveEnviarEmailSimples(){

        usecase.sendEmail(new EmailEntity("mail@test.com", "Assunto", "Corpo do email"));

        ArgumentCaptor<SimpleMailMessage> captor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(mailSender).send(captor.capture());

        SimpleMailMessage message = captor.getValue();
        Assertions.assertNotNull(message.getTo());
        assertEquals("brunoeuflausino@gmail.com", message.getTo()[0]);
        assertEquals("mail@test.com está te enviando um email! Assunto: Assunto", message.getSubject());
        assertEquals("Corpo do email", message.getText());


    }

}