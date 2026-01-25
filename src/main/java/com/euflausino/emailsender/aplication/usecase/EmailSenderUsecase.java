package com.euflausino.emailsender.aplication.usecase;

import com.euflausino.emailsender.aplication.entity.EmailEntity;
import com.euflausino.emailsender.aplication.exception.EmailNaoEnviadoException;
import com.euflausino.emailsender.aplication.ports.input.ISendEmailInput;
import org.hibernate.cfg.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailSenderUsecase implements ISendEmailInput {

    private final JavaMailSender mailSender;

    public EmailSenderUsecase(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(EmailEntity email) {
        String emmailAndAssunto = email.getEmail() + " está te enviando um email! Assunto: " +email.getAssunto();
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(Environment.getProperties().getProperty("spring.mail.username"));
            message.setTo("brunoeuflausino@gmail.com");
            message.setSubject(emmailAndAssunto);
            message.setText(email.getMensagem());
            mailSender.send(message);
        }catch(EmailNaoEnviadoException e){
           throw new EmailNaoEnviadoException("O email não pode ser enviado.");
        }
    }

}
