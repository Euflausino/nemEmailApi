package com.euflausino.emailsender.adapter.output;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmailRepository extends JpaRepository<EmailJPA, String> {
}
