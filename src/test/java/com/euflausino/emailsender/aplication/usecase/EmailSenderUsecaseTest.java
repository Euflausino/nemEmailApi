package com.euflausino.emailsender.aplication.usecase;

import com.euflausino.emailsender.aplication.entity.EmailEntity;
import com.euflausino.emailsender.aplication.entity.EmailOtherEntity;
import com.euflausino.emailsender.aplication.exception.EmailNaoEnviadoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("EmailSenderUsecase Tests")
class EmailSenderUsecaseTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailSenderUsecase emailSenderUsecase;

    private EmailEntity emailEntity;
    private EmailOtherEntity emailOtherEntity;

    @BeforeEach
    void setUp() {
        emailEntity = new EmailEntity("test@example.com", "Subject", "Message");
        emailOtherEntity = new EmailOtherEntity("test@example.com", "Subject", "Message");
    }

    @Test
    @DisplayName("Deve enviar email com sucesso")
    void deveEnviarEmailComSucesso() {
        emailSenderUsecase.sendEmail(emailEntity);

        verify(mailSender).send(any(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("Deve enviar email com sucesso")
    void deveEnviarEmailParaOutroComSucesso() {
        emailSenderUsecase.sendEmailToOthers(emailOtherEntity);

        verify(mailSender).send(any(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("Deve lançar exceção quando falhar ao enviar email")
    void deveLancarExcecaoQuandoFalhar() {
        doThrow(new MailSendException("Failed")).when(mailSender).send(any(SimpleMailMessage.class));

        EmailNaoEnviadoException exception = assertThrows(EmailNaoEnviadoException.class, () -> {
            emailSenderUsecase.sendEmail(emailEntity);
        });

        assertEquals("O email não pode ser enviado.", exception.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando falhar ao enviar email")
    void deveLancarExcecaoQuandoFalharEmailOutro() {
        doThrow(new MailSendException("Failed")).when(mailSender).send(any(SimpleMailMessage.class));

        EmailNaoEnviadoException exception = assertThrows(EmailNaoEnviadoException.class, () -> {
            emailSenderUsecase.sendEmailToOthers(emailOtherEntity);
        });

        assertEquals("O email não pode ser enviado.", exception.getMessage());
    }
}
