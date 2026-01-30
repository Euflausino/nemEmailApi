package com.euflausino.emailsender.security;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestCorsConfig.class)
@ActiveProfiles("test")
public class SecurityMailTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveBloquearQuandoUltrapassarLimite() throws Exception {

        for (int i = 0; i < 5; i++) {
            mockMvc.perform(get("/email/health"))
                    .andExpect(status().isOk());
        }

        // Excedeu o limite
        mockMvc.perform(get("/email/health"))
                .andExpect(status().isTooManyRequests());

    }

}
