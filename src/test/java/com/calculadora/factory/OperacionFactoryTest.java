package com.calculadora.factory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;

import com.calculadora.exception.OperacionInvalidaException;
import com.calculadora.model.Operacion;
import com.calculadora.model.Resta;
import com.calculadora.model.Suma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class OperacionFactoryTest {
  private OperacionFactory operacionFactory;

  @Mock
  private Operacion suma;

  @Mock
  private Operacion resta;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    //Si se pasan Suma y Resta mockeadas al constructor se crean con una key en el mapa distinta al nombre de la clase, 
    // lo que provoca que siempre lance un OperacionInvalidaException
    operacionFactory = new OperacionFactory(Arrays.asList(new Suma(), new Resta()));
  }

  @Test
  void deberiaCrearOperacionSumaTest() {
    when(suma.calcular(anyList())).thenReturn(new BigDecimal(15));
    Operacion operacion = operacionFactory.crearOperacion("suma");
    BigDecimal resultado = operacion.calcular(Arrays.asList(new BigDecimal(10), new BigDecimal(5)));
    assertEquals(new BigDecimal(15), resultado);
  }

  @Test
  void deberiaCrearOperacionRestaTest() {
    when(resta.calcular(anyList())).thenReturn(new BigDecimal(5));
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