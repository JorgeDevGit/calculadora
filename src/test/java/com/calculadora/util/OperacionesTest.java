package com.calculadora.util;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class OperacionesTest {
    
    @Test
     public void deberiaCalcularLaSumaDeDosNumeros(){
        // Preparación de datos de prueba
        List<BigDecimal> operandos = new ArrayList<>();
        operandos.add(BigDecimal.valueOf(2.5));
        operandos.add(BigDecimal.valueOf(3));

        // Ejecución del método a probar
        BigDecimal resultado = Operaciones.suma(operandos);

        // Comprobación del resultado
        BigDecimal resultadoEsperado = BigDecimal.valueOf(5.5);
        Assertions.assertEquals(resultadoEsperado, resultado);
    }

    @Test
     void deberiaCalcularLaRestaDeDosNumeros(){
        // Preparación de datos de prueba
        List<BigDecimal> operandos = new ArrayList<>();
        operandos.add(BigDecimal.valueOf(5.5));
        operandos.add(BigDecimal.valueOf(3));

        // Ejecución del método a probar
        BigDecimal resultado = Operaciones.resta(operandos);

        // Comprobación del resultado
        BigDecimal resultadoEsperado = BigDecimal.valueOf(2.5);
        Assertions.assertEquals(resultadoEsperado, resultado);
    }
}
