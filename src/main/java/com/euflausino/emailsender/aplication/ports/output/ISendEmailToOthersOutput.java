package com.euflausino.emailsender.aplication.ports.output;

import com.euflausino.emailsender.aplication.entity.EmailOtherEntity;

public interface ISendEmailToOthersOutput {
    void sendEmailToOthers(EmailOtherEntity email);
}
