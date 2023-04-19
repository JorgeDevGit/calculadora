package com.calculadora.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import com.calculadora.exception.OperacionInvalidaException;
import com.calculadora.factory.OperacionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CalculadoraServiceTest {

  @Autowired
  OperacionFactory operacionFactory;

  @Autowired
  CalculadoraServiceImpl calculadoraService;

  @Test
  void deberiaSumarDosNumeros() {
    // Preparación de datos de prueba
    List<BigDecimal> operandos = Arrays.asList(new BigDecimal("2"), new BigDecimal("3"));

    // Ejecución del método a probar
    BigDecimal resultado = calculadoraService.calcular(operandos, "suma");

    // Comprobación del resultado
    Assertions.assertEquals(new BigDecimal("5"), resultado);
  }

  @Test
  void deberiaRestarDosNumeros() {
    // Preparación de datos de prueba
    List<BigDecimal> operandos = Arrays.asList(new BigDecimal("5"), new BigDecimal("3"));

    // Ejecución del método a probar
    BigDecimal resultado = calculadoraService.calcular(operandos, "resta");

    // Comprobación del resultado
    Assertions.assertEquals(new BigDecimal("2"), resultado);
  }

  @Test
  void deberiarlanzarExcepcion() {
    // Preparación de datos de prueba
    String operador = "multiplicacion";

    // Ejecución del método a probar y comprobación del resultado
    assertThatThrownBy(() -> operacionFactory.crearOperacion(operador))
            .isInstanceOf(OperacionInvalidaException.class)
            .hasMessageContaining("Operacion invalida: " + operador);
  }
}
