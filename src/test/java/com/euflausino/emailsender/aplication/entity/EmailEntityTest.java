package com.euflausino.emailsender.aplication.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("EmailEntity Tests")
class EmailEntityTest {

    private EmailEntity email;
    private EmailOtherEntity emailOtherEntity;

    @BeforeEach
    void setUp() {
        email = new EmailEntity("test@example.com", "Subject", "Message body");
        emailOtherEntity = new EmailOtherEntity("test@example.com", "Subject", "Message body");

    }

    @Test
    @DisplayName("Deve criar EmailEntity com construtor parametrizado")
    void deveCriarEmailEntityComConstructor() {
        assertNotNull(email);
        assertEquals("test@example.com", email.getEmail());
        assertEquals("Subject", email.getAssunto());
        assertEquals("Message body", email.getMensagem());
    }

    @Test
    @DisplayName("Deve criar EmailEntity com construtor vazio")
    void deveCriarEmailEntityComConstructorVazio() {
        EmailEntity emailVazio = new EmailEntity();
        assertNotNull(emailVazio);
    }

    @Test
    @DisplayName("Deve validar email não nulo")
    void deveValidarEmailNaoNulo() {
        assertNotNull(email.getEmail());
        assertFalse(email.getEmail().isEmpty());
    }

    @Test
    @DisplayName("Deve validar assunto não nulo")
    void deveValidarAssuntoNaoNulo() {
        assertNotNull(email.getAssunto());
        assertFalse(email.getAssunto().isEmpty());
    }

    @Test
    @DisplayName("Deve validar mensagem não nula")
    void deveValidarMensagemNaoNula() {
        assertNotNull(email.getMensagem());
        assertFalse(email.getMensagem().isEmpty());
    }

    @Test
    @DisplayName("Deve modificar email via setter")
    void deveModificarEmailViasetter() {
        email.setEmail("novo@example.com");
        assertEquals("novo@example.com", email.getEmail());
    }

    @Test
    @DisplayName("Deve modificar assunto via setter")
    void deveModificarAssuntoViaSettr() {
        email.setAssunto("Novo Assunto");
        assertEquals("Novo Assunto", email.getAssunto());
    }

    @Test
    @DisplayName("Deve modificar mensagem via setter")
    void deveModificarMensagemViaSetter() {
        email.setMensagem("Nova mensagem");
        assertEquals("Nova mensagem", email.getMensagem());
    }

    @Test
    @DisplayName("Deve validar email com múltiplos campos")
    void deveValidarEmailComMultiplosCampos() {
        EmailEntity novoEmail = new EmailEntity("user@domain.com", "Bem-vindo", "Conteúdo");
        assertEquals("user@domain.com", novoEmail.getEmail());
        assertEquals("Bem-vindo", novoEmail.getAssunto());
        assertEquals("Conteúdo", novoEmail.getMensagem());
    }

    @Test
    @DisplayName("Deve criar EmailEntity com construtor parametrizado")
    void deveCriarEmailOtherEntityComConstructor() {
        assertNotNull(emailOtherEntity);
        assertEquals("test@example.com", emailOtherEntity.getEmail());
        assertEquals("Subject", emailOtherEntity.getAssunto());
        assertEquals("Message body", emailOtherEntity.getMensagem());
    }

    @Test
    @DisplayName("Deve criar EmailEntity com construtor vazio")
    void deveCriarEmailOtherEntityComConstructorVazio() {
        EmailOtherEntity emailVazio = new EmailOtherEntity();
        assertNotNull(emailVazio);
    }

    @Test
    @DisplayName("Deve validar email não nulo")
    void deveValidarEmailOtherNaoNulo() {
        assertNotNull(emailOtherEntity.getEmail());
        assertFalse(emailOtherEntity.getEmail().isEmpty());
    }

    @Test
    @DisplayName("Deve validar assunto não nulo")
    void deveValidarAssuntoNaoOtherNulo() {
        assertNotNull(emailOtherEntity.getAssunto());
        assertFalse(emailOtherEntity.getAssunto().isEmpty());
    }

    @Test
    @DisplayName("Deve validar mensagem não nula")
    void deveValidarMensagemNaoNulaOther() {
        assertNotNull(emailOtherEntity.getMensagem());
        assertFalse(emailOtherEntity.getMensagem().isEmpty());
    }

    @Test
    @DisplayName("Deve modificar email via setter")
    void deveModificarEmailViasetterOther() {
        emailOtherEntity.setEmail("novo@example.com");
        assertEquals("novo@example.com", emailOtherEntity.getEmail());
    }

    @Test
    @DisplayName("Deve modificar assunto via setter")
    void deveModificarAssuntoViaSettrOther() {
        emailOtherEntity.setAssunto("Novo Assunto");
        assertEquals("Novo Assunto", emailOtherEntity.getAssunto());
    }

    @Test
    @DisplayName("Deve modificar mensagem via setter")
    void deveModificarMensagemViaSetterOther() {
        emailOtherEntity.setMensagem("Nova mensagem");
        assertEquals("Nova mensagem", emailOtherEntity.getMensagem());
    }

    @Test
    @DisplayName("Deve validar email com múltiplos campos")
    void deveValidarEmailComMultiplosCamposOther() {
        EmailOtherEntity novoEmail = new EmailOtherEntity("user@domain.com", "Bem-vindo", "Conteúdo");
        assertEquals("user@domain.com", novoEmail.getEmail());
        assertEquals("Bem-vindo", novoEmail.getAssunto());
        assertEquals("Conteúdo", novoEmail.getMensagem());
    }
}

