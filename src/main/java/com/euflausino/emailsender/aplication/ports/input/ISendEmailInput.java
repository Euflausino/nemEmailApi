package com.euflausino.emailsender.aplication.ports.input;

import com.euflausino.emailsender.aplication.entity.EmailEntity;

public interface ISendEmailInput {
    void sendEmail(EmailEntity email);
}
