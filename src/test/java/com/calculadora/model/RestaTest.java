package com.calculadora.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RestaTest {
  private final Resta resta = new Resta();
  @Test
  void calcularDosOperandosCorrectamente() {
    // Preparación de datos de prueba
    BigDecimal primerOperando = new BigDecimal("5");
    BigDecimal segundoOperando = new BigDecimal("3");
    List<BigDecimal> operandos = Arrays.asList(primerOperando, segundoOperando);

    // Ejecución del método a probar
    BigDecimal resultado = resta.calcular(operandos);

    // Comprobación del resultado
    assertEquals(new BigDecimal("2"), resultado);
  }

  @Test
  void calcularTresOperandosCorrectamente() {
    // Preparación de datos de prueba
    BigDecimal primerOperando = new BigDecimal("10");
    BigDecimal segundoOperando = new BigDecimal("3");
    BigDecimal tercerOperando = new BigDecimal("2");
    List<BigDecimal> operandos = Arrays.asList(primerOperando, segundoOperando, tercerOperando);

    // Ejecución del método a probar
    BigDecimal resultado = resta.calcular(operandos);

    // Comprobación del resultado
    assertEquals(new BigDecimal("5"), resultado);
  }
  
}