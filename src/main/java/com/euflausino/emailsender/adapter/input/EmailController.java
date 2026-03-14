package com.euflausino.emailsender.adapter.input;

import com.euflausino.emailsender.adapter.input.dtos.EmailRequestDTO;
import com.euflausino.emailsender.adapter.input.dtos.OthersEmailRequestDTO;
import com.euflausino.emailsender.adapter.input.dtos.mapper.EmailMapper;
import com.euflausino.emailsender.aplication.entity.EmailOtherEntity;
import com.euflausino.emailsender.aplication.ports.input.ISendEmailInput;
import com.euflausino.emailsender.aplication.ports.input.ISendEmailToOthersInput;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

   private final ISendEmailInput sendEmail;
   private final ISendEmailToOthersInput sendEmailToOthers;

    public EmailController(ISendEmailInput sendEmail, ISendEmailToOthersInput sendEmailToOthers) {
        this.sendEmail = sendEmail;
        this.sendEmailToOthers = sendEmailToOthers;
    }

    @PostMapping
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody EmailRequestDTO emailRequestDTO) {
        sendEmail.iSendEmail(EmailMapper.toEmailEntity(emailRequestDTO));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/others")
    public ResponseEntity<Void> sendEmailToOthers(@Valid @RequestBody OthersEmailRequestDTO emailRequestDTO) {
        sendEmailToOthers.iSendEmailToOthers(EmailMapper.toEmailOtherEntity(emailRequestDTO));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

}
