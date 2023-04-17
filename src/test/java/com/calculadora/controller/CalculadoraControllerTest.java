package com.calculadora.controller;

import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CalculadoraControllerTest {

    @Autowired
    private CalculadoraController calculadoraController;
    
    @Test
    void calculaSumaTest() {
        // Preparación de datos de prueba
        List<BigDecimal> operandos = new ArrayList<>();
        operandos.add(BigDecimal.valueOf(1));
        operandos.add(BigDecimal.valueOf(1.5));
        String operacion = "suma";

        // Ejecución del método a probar
        ResponseEntity<BigDecimal> response = calculadoraController.calcula(operandos, operacion);

        // Comprobación del resultado
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(BigDecimal.valueOf(2.5), response.getBody());
    }

    @Test
    void calculaRestaTest() {
        // Preparación de datos de prueba
        List<BigDecimal> operandos = new ArrayList<>();
        operandos.add(BigDecimal.valueOf(10));
        operandos.add(BigDecimal.valueOf(5.5));
        String operacion = "resta";

        // Ejecución del método a probar
        ResponseEntity<BigDecimal> response = calculadoraController.calcula(operandos, operacion);

        // Comprobación del resultado
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(BigDecimal.valueOf(4.5), response.getBody());
    }
}