package com.euflausino.emailsender.adapter.input.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ResponseErrorDTO(
        String message,
        int status,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDateTime time
) {
    public ResponseErrorDTO(String message, int status){
        this( message, status, LocalDateTime.now() );
    }
}
