package com.euflausino.emailsender.adapter.input;

import com.euflausino.emailsender.adapter.input.dtos.EmailRequestDTO;
import com.euflausino.emailsender.adapter.input.dtos.mapper.EmailMapper;
import com.euflausino.emailsender.aplication.ports.input.ISendEmailInput;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

   private final ISendEmailInput sendEmail;

    public EmailController(ISendEmailInput sendEmail) {
        this.sendEmail = sendEmail;
    }

    @PostMapping
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody EmailRequestDTO emailRequestDTO) {
        sendEmail.sendEmail(EmailMapper.toEmailEntity(emailRequestDTO));
        return ResponseEntity.ok().build();
    }
}
