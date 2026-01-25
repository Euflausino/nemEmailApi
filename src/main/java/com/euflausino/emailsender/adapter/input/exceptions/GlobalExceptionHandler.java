package com.euflausino.emailsender.adapter.input.exceptions;

import com.euflausino.emailsender.adapter.input.dtos.ResponseErrorDTO;
import com.euflausino.emailsender.aplication.exception.EmailNaoEnviadoException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailNaoEnviadoException.class)
    public ResponseEntity<ResponseErrorDTO> handleException(EmailNaoEnviadoException e){
        return ResponseEntity.badRequest().body(new ResponseErrorDTO(e.getMessage(),  HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseErrorDTO> handleGenericException(Exception ex) {
        return ResponseEntity.internalServerError().body(new ResponseErrorDTO(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldErrors().get(0);
        return ResponseEntity.badRequest().body(new ResponseErrorDTO(fieldError.getDefaultMessage(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseErrorDTO> handleConstraintViolationException(ConstraintViolationException ex){
        return ResponseEntity.badRequest().body(new ResponseErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseErrorDTO> handleRuntimeException(RuntimeException ex){
        return ResponseEntity.internalServerError().body(new ResponseErrorDTO(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    public ResponseEntity<ResponseErrorDTO> handleHttpClientErrorException(HttpClientErrorException.Forbidden ex){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResponseErrorDTO(ex.getMessage(), HttpStatus.FORBIDDEN.value()));
    }

}
