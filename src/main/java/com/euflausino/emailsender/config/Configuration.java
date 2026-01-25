package com.euflausino.emailsender.config;


import com.euflausino.emailsender.aplication.ports.output.IEmailSaveOutput;
import com.euflausino.emailsender.aplication.usecase.EmailSenderUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public EmailSenderUsecase emailSenderUsecase(IEmailSaveOutput saveEmail, JavaMailSender mailSender){
        return new EmailSenderUsecase(saveEmail, mailSender);
    }

}
