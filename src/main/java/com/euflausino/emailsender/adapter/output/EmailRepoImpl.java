package com.euflausino.emailsender.adapter.output;

import com.euflausino.emailsender.adapter.output.mapper.EmailOutputMapper;
import com.euflausino.emailsender.aplication.entity.EmailEntity;
import com.euflausino.emailsender.aplication.ports.output.IEmailSaveOutput;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepoImpl implements IEmailSaveOutput {

    private final EmailRepository emailRepository;

    public EmailRepoImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }


    @Override
    public void saveEmail(EmailEntity email) {
        EmailJPA toSave = EmailOutputMapper.toJPA(email);
        emailRepository.save(toSave);
    }
}
