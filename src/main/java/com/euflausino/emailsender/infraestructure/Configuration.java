package com.euflausino.emailsender.infraestructure;


import com.euflausino.emailsender.aplication.usecase.EmailSenderUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public EmailSenderUsecase emailSenderUsecase(JavaMailSender mailSender){
        return new EmailSenderUsecase(mailSender);
    }

}
