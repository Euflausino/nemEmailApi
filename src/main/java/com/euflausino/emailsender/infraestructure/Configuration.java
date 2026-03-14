package com.euflausino.emailsender.infraestructure;


import com.euflausino.emailsender.adapter.output.SpringMail;
import com.euflausino.emailsender.aplication.ports.output.ISendEmailOutput;
import com.euflausino.emailsender.aplication.ports.output.ISendEmailToOthersOutput;
import com.euflausino.emailsender.aplication.usecase.EmailSenderUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public EmailSenderUsecase emailSenderUsecase(ISendEmailOutput sendEmailOutput, ISendEmailToOthersOutput sendEmailToOthersOutput) {
        return new EmailSenderUsecase(sendEmailOutput, sendEmailToOthersOutput);
    }

    @Bean
    public SpringMail springMail(JavaMailSender mailSender) {
        return new SpringMail(mailSender);
    }

}
