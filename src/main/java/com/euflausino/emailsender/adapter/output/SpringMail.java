package com.euflausino.emailsender.adapter.output;

import com.euflausino.emailsender.aplication.entity.EmailEntity;
import com.euflausino.emailsender.aplication.entity.EmailOtherEntity;
import com.euflausino.emailsender.aplication.exception.EmailNaoEnviadoException;
import com.euflausino.emailsender.aplication.ports.output.ISendEmailOutput;
import com.euflausino.emailsender.aplication.ports.output.ISendEmailToOthersOutput;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SpringMail implements ISendEmailOutput, ISendEmailToOthersOutput {

    private final JavaMailSender mailSender;

    public SpringMail(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(EmailEntity email) {
        String emmailAndAssunto = email.getEmail() + " está te enviando um email! Assunto: " +email.getAssunto();
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("${spring.mail.username}");
            message.setTo("brunoeuflausino@gmail.com");
            message.setSubject(emmailAndAssunto);
            message.setText(email.getMensagem());
            mailSender.send(message);
        }catch(Exception e){
            throw new EmailNaoEnviadoException("O email não pode ser enviado.");
        }
    }

    @Override
    public void sendEmailToOthers(EmailOtherEntity email) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("${spring.mail.username}");
            message.setTo(email.getEmail());
            message.setSubject(email.getAssunto());
            message.setText(email.getMensagem());
            mailSender.send(message);
        }catch(Exception e){
            throw new EmailNaoEnviadoException("O email não pode ser enviado.");
        }
    }

}
