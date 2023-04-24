package com.calculadora.controller;

import com.calculadora.service.CalculadoraService;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CalculadoraControllerTest {

    @Mock
    private CalculadoraService calculadoraService;

    @Mock
    private TracerImpl tracer;

    @InjectMocks
    private CalculadoraController calculadoraController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void calculaSumaTest() {
        // Preparación de datos de prueba
        List<BigDecimal> operandos = Arrays.asList(BigDecimal.valueOf(1),BigDecimal.valueOf(1.5));
        String operacion = "suma";
        BigDecimal resultadoEsperado = BigDecimal.valueOf(2.5);

        // Configuración del mock
        Mockito.when(calculadoraService.calcular(operandos, operacion)).thenReturn(resultadoEsperado);

        // Ejecución del método a probar
        ResponseEntity<BigDecimal> response = calculadoraController.calcula(operandos, operacion);

        // Comprobación del resultado
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(resultadoEsperado, response.getBody());

        // Verificación de las interacciones con los mocks
        Mockito.verify(calculadoraService, Mockito.times(1)).calcular(operandos, operacion);
        Mockito.verify(tracer, Mockito.times(1)).trace(resultadoEsperado);
        Mockito.verifyNoMoreInteractions(calculadoraService, tracer);
    }

    @Test
    void calculaRestaTest() {
        // Preparación de datos de prueba
        List<BigDecimal> operandos = Arrays.asList(BigDecimal.valueOf(10), BigDecimal.valueOf(5.5));
        String operacion = "resta";
        BigDecimal resultadoEsperado = BigDecimal.valueOf(4.5);

        // Configuración del mock
        Mockito.when(calculadoraService.calcular(operandos, operacion)).thenReturn(resultadoEsperado);

        // Ejecución del método a probar
        ResponseEntity<BigDecimal> response = calculadoraController.calcula(operandos, operacion);

        // Comprobación del resultado
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(resultadoEsperado, response.getBody());

        // Verificación de las interacciones con los mocks
        Mockito.verify(calculadoraService, Mockito.times(1)).calcular(operandos, operacion);
        Mockito.verify(tracer, Mockito.times(1)).trace(resultadoEsperado);
        Mockito.verifyNoMoreInteractions(calculadoraService, tracer);
    }

}