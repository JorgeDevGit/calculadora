package com.calculadora.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CalculadoraServiceTest {

    private CalculadoraService calculadoraService;

    @BeforeEach
    void setUp() {
        calculadoraService = new CalculadoraServiceImpl();
    }

    @Test
    void deberiaSumarDosNumeros() {
        // Preparación de datos de prueba
        List<BigDecimal> operandos = new ArrayList<>();
        operandos.add(BigDecimal.valueOf(2));
        operandos.add(BigDecimal.valueOf(3.5));
        String operador = "suma";

        // Ejecución del método a probar
        BigDecimal resultado = calculadoraService.calcular(operandos, operador);

        // Comprobación del resultado
        BigDecimal resultadoEsperado = BigDecimal.valueOf(5.5);
        Assertions.assertEquals(resultadoEsperado, resultado, "La suma de 2 y 3.5 debería ser 5.5");
    }

    @Test
    void deberiaRestarDosNumeros() {
        // Preparación de datos de prueba
        List<BigDecimal> operandos = new ArrayList<>();
        operandos.add(BigDecimal.valueOf(7.5));
        operandos.add(BigDecimal.valueOf(4));
        String operador = "resta";

        // Ejecución del método a probar
        BigDecimal resultado = calculadoraService.calcular(operandos, operador);

        // Comprobación del resultado
        BigDecimal resultadoEsperado = BigDecimal.valueOf(3.5);
        Assertions.assertEquals(resultadoEsperado, resultado, "La resta de 7.5 y 4 debería ser 3.5");
    }

    @Test
    void deberiaLanzarExcepcionCuandoSeUsaOperadorInvalido() {
        // Preparación de datos de prueba
        List<BigDecimal> operandos = new ArrayList<>();
        operandos.add(BigDecimal.valueOf(2));
        operandos.add(BigDecimal.valueOf(3.5));
        String operadorInvalido = "operador-invalido";

        // Ejecución del método a probar y comprobación de la excepción
        Assertions.assertThrows(RuntimeException.class, () -> calculadoraService.calcular(operandos, operadorInvalido));
    }
}
