package com.euflausino.emailsender.aplication.ports.output;

import com.euflausino.emailsender.aplication.entity.EmailEntity;

public interface IEmailSaveOutput {
    void saveEmail(EmailEntity email);
}
