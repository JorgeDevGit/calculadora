package com.calculadora.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest 
class OperacionInvalidaExceptionTest {
    @Test
     void testMensaje() {
        String mensaje = "Operacion inválida";
        OperacionInvalidaException exception = new OperacionInvalidaException(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }
}
