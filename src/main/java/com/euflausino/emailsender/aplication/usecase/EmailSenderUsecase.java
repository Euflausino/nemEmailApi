package com.euflausino.emailsender.aplication.usecase;

import com.euflausino.emailsender.aplication.entity.EmailEntity;
import com.euflausino.emailsender.aplication.entity.EmailOtherEntity;
import com.euflausino.emailsender.aplication.exception.EmailNaoEnviadoException;
import com.euflausino.emailsender.aplication.ports.input.ISendEmailInput;
import com.euflausino.emailsender.aplication.ports.input.ISendEmailToOthersInput;
import com.euflausino.emailsender.aplication.ports.output.ISendEmailOutput;
import com.euflausino.emailsender.aplication.ports.output.ISendEmailToOthersOutput;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailSenderUsecase implements ISendEmailInput, ISendEmailToOthersInput {

    private final ISendEmailOutput sendEmailOutput;
    private final ISendEmailToOthersOutput sendEmailToOthersOutput;

    public EmailSenderUsecase(ISendEmailOutput sendEmailOutput, ISendEmailToOthersOutput sendEmailToOthersOutput) {
        this.sendEmailOutput = sendEmailOutput;
        this.sendEmailToOthersOutput = sendEmailToOthersOutput;
    }

    @Override
    public  void iSendEmail(EmailEntity email) {
        sendEmailOutput.sendEmail(email);
    }

    @Override
    public  void iSendEmailToOthers(EmailOtherEntity email) {
        sendEmailToOthersOutput.sendEmailToOthers(email);
    }

}
