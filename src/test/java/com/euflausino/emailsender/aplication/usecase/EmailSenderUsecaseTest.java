package com.euflausino.emailsender.aplication.usecase;

import com.euflausino.emailsender.aplication.entity.EmailEntity;
import com.euflausino.emailsender.aplication.entity.EmailOtherEntity;
import com.euflausino.emailsender.aplication.ports.output.ISendEmailOutput;
import com.euflausino.emailsender.aplication.ports.output.ISendEmailToOthersOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmailSenderUsecaseTest {

    @Mock
    private ISendEmailOutput sendEmailOutput;

    @Mock
    private ISendEmailToOthersOutput sendEmailToOthersOutput;

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
    void deveEnviarEmailComSucesso() {
        emailSenderUsecase.iSendEmail(emailEntity);

        verify(sendEmailOutput).sendEmail(emailEntity);
    }

    @Test
    void deveEnviarEmailParaOutroComSucesso() {
        emailSenderUsecase.iSendEmailToOthers(emailOtherEntity);

        verify(sendEmailToOthersOutput).sendEmailToOthers(emailOtherEntity);
    }
}
