package com.euflausino.emailsender.aplication.ports.input;

import com.euflausino.emailsender.aplication.entity.EmailOtherEntity;

public interface ISendEmailToOthersInput {
    void sendEmailToOthers(EmailOtherEntity email);
}
