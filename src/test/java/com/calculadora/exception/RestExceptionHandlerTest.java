package com.calculadora.exception;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class RestExceptionHandlerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void handleOperacionInvalidaException() throws Exception {
    
    mockMvc.perform(MockMvcRequestBuilders.get("/api/calculo")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{ \"operador\": \"multiplicacion\" }"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  void handleMethodConstraintViolation() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/calculo")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{}"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }
}