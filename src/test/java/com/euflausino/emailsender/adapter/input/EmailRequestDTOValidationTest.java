package com.euflausino.emailsender.adapter.input;

import com.euflausino.emailsender.adapter.input.dtos.EmailRequestDTO;
import com.euflausino.emailsender.adapter.input.dtos.OthersEmailRequestDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("EmailRequestDTO Validation Tests")
class EmailRequestDTOValidationTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("Deve validar EmailRequestDTO válido")
    void deveValidarEmailRequestDTOValido() {
        EmailRequestDTO request = new EmailRequestDTO("test@example.com", "Assunto", "Mensagem");

        Set<ConstraintViolation<EmailRequestDTO>> violations = validator.validate(request);

        assertTrue(violations.isEmpty());
    }

    @Test
    @DisplayName("Deve invalidar email vazio")
    void deveInvalidarEmailVazio() {
        EmailRequestDTO request = new EmailRequestDTO("", "Assunto", "Mensagem");

        Set<ConstraintViolation<EmailRequestDTO>> violations = validator.validate(request);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("Email obrigatório!", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("Deve invalidar email inválido")
    void deveInvalidarEmailInvalido() {
        EmailRequestDTO request = new EmailRequestDTO("invalid-email", "Assunto", "Mensagem");

        Set<ConstraintViolation<EmailRequestDTO>> violations = validator.validate(request);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("Email inváalido!", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("Deve validar EmailRequestDTO válido")
    void deveValidarOtherEmailRequestDTOValido() {
        OthersEmailRequestDTO request = new OthersEmailRequestDTO("test@example.com", "Assunto", "Mensagem");

        Set<ConstraintViolation<OthersEmailRequestDTO>> violations = validator.validate(request);

        assertTrue(violations.isEmpty());
    }

    @Test
    @DisplayName("Deve invalidar email vazio")
    void deveInvalidarEmailVazioOther() {
        OthersEmailRequestDTO request = new OthersEmailRequestDTO("", "Assunto", "Mensagem");

        Set<ConstraintViolation<OthersEmailRequestDTO>> violations = validator.validate(request);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("Email obrigatório!", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("Deve invalidar email inválido")
    void deveInvalidarEmailInvalidoOther() {
        OthersEmailRequestDTO request = new OthersEmailRequestDTO("invalid-email", "Assunto", "Mensagem");

        Set<ConstraintViolation<OthersEmailRequestDTO>> violations = validator.validate(request);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("Email inváalido!", violations.iterator().next().getMessage());
    }
}
