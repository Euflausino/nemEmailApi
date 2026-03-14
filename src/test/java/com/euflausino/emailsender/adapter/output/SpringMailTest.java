package com.euflausino.emailsender.adapter.output;

import com.euflausino.emailsender.aplication.entity.EmailEntity;
import com.euflausino.emailsender.aplication.entity.EmailOtherEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class SpringMailTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private SpringMail springMail;

    @Test
    void deveEnviarEmail() {

        EmailEntity email = new EmailEntity("test@test.com","Subject","Message");

        springMail.sendEmail(email);

        verify(mailSender).send(any(SimpleMailMessage.class));
    }

    @Test
    void deveEnviarEmailParOutro() {

        EmailOtherEntity email = new EmailOtherEntity("test@test.com","Subject","Message");

        springMail.sendEmailToOthers(email);

        verify(mailSender).send(any(SimpleMailMessage.class));
    }
}
