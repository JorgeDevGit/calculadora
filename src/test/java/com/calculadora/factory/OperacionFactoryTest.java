package com.calculadora.factory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import com.calculadora.exception.OperacionInvalidaException;
import com.calculadora.service.Operacion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OperacionFactoryTest {

  @Autowired
  private OperacionFactory operacionFactory;

  @Test
  void deberiaCrearOperacionSumaTest() {
    Operacion operacion = operacionFactory.crearOperacion("suma");
    BigDecimal resultado = operacion.calcular(Arrays.asList(new BigDecimal(10), new BigDecimal(5)));
    assertEquals(new BigDecimal(15), resultado);
  }

  @Test
  void deberiaCrearOperacionRestaTest() {
    Operacion operacion = operacionFactory.crearOperacion("resta");
    BigDecimal resultado = operacion.calcular(Arrays.asList(new BigDecimal(10), new BigDecimal(5)));
    assertEquals(new BigDecimal(5), resultado);
  }

  @Test
  void deberiarlanzarExcepcion() {
    // Preparación de datos de prueba
    String operador = "operacionInvalida";

    // Ejecución del método a probar y comprobación del resultado
    assertThatThrownBy(() -> operacionFactory.crearOperacion(operador))
            .isInstanceOf(OperacionInvalidaException.class)
            .hasMessageContaining("Operacion invalida: " + operador);
  }
  
}