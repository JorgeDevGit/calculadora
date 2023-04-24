package com.calculadora.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.calculadora.model.Suma;
import org.junit.jupiter.api.Test;

class SumaTest {

  private final Suma suma = new Suma();

  @Test
  void calcularDosOperandosCorrectamente() {
    // Preparación de datos de prueba
    BigDecimal primerOperando = new BigDecimal("5");
    BigDecimal segundoOperando = new BigDecimal("3");
    List<BigDecimal> operandos = Arrays.asList(primerOperando, segundoOperando);

    // Ejecución del método a probar
    BigDecimal resultado = suma.calcular(operandos);

    // Comprobación del resultado
    assertEquals(new BigDecimal("8"), resultado);
  }

  @Test
  void calcularTresOperandosCorrectamente() {
    // Preparación de datos de prueba
    BigDecimal primerOperando = new BigDecimal("10");
    BigDecimal segundoOperando = new BigDecimal("3");
    BigDecimal tercerOperando = new BigDecimal("2");
    List<BigDecimal> operandos = Arrays.asList(primerOperando, segundoOperando, tercerOperando);

    // Ejecución del método a probar
    BigDecimal resultado = suma.calcular(operandos);

    // Comprobación del resultado
    assertEquals(new BigDecimal("15"), resultado);
  }
  
}