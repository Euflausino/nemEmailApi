package com.euflausino.emailsender.aplication.exception;

public class EmailNaoEnviadoException extends RuntimeException {
    public EmailNaoEnviadoException(String message) {
        super(message);
    }
}
