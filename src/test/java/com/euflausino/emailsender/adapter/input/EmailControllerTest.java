//package com.euflausino.emailsender.adapter.input;
//
//import com.euflausino.emailsender.adapter.input.dtos.EmailRequestDTO;
//import com.euflausino.emailsender.adapter.input.dtos.OthersEmailRequestDTO;
//import com.euflausino.emailsender.aplication.ports.input.ISendEmailInput;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.security.test.context.support.WithMockUser;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.doNothing;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(EmailController.class)
//@AutoConfigureMockMvc(addFilters = false)
//@DisplayName("EmailController Tests")
//@ActiveProfiles("test")
//class EmailControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ISendEmailInput sendEmailInput;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    @DisplayName("Deve enviar email com sucesso")
//    @WithMockUser
//    void deveEnviarEmailComSucesso() throws Exception {
//        EmailRequestDTO request = new EmailRequestDTO("test@example.com", "Assunto", "Mensagem");
//
//        doNothing().when(sendEmailInput).sendEmail(any());
//
//        mockMvc.perform(post("/email")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    @DisplayName("Deve retornar erro para email inválido")
//    @WithMockUser
//    void deveRetornarErroParaEmailInvalido() throws Exception {
//        EmailRequestDTO request = new EmailRequestDTO("", "Assunto", "Mensagem");
//
//        mockMvc.perform(post("/email")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isBadRequest());
//    }
//
//    @Test
//    @DisplayName("Deve enviar email com sucesso")
//    @WithMockUser
//    void deveEnviarOtherEmailComSucesso() throws Exception {
//        OthersEmailRequestDTO request = new OthersEmailRequestDTO("test@example.com", "Assunto", "Mensagem");
//
//        doNothing().when(sendEmailInput).sendEmail(any());
//
//        mockMvc.perform(post("/email/others")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    @DisplayName("Deve retornar erro para email inválido")
//    @WithMockUser
//    void deveRetornarErroParaEmailOthersInvalido() throws Exception {
//        OthersEmailRequestDTO request = new OthersEmailRequestDTO("", "Assunto", "Mensagem");
//
//        mockMvc.perform(post("/email/others")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isBadRequest());
//    }
//
//    @Test
//    @DisplayName("Deve retornar health check")
//    @WithMockUser
//    void deveRetornarHealthCheck() throws Exception {
//        mockMvc.perform(get("/email/health"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("OK"));
//    }
//}
