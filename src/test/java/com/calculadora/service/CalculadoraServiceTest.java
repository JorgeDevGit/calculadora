package com.calculadora.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.calculadora.exception.OperacionInvalidaException;
import com.calculadora.factory.OperacionFactory;
import com.calculadora.model.Operacion;
import com.calculadora.model.Resta;
import com.calculadora.model.Suma;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CalculadoraServiceTest {

  @Mock
  OperacionFactory operacionFactory;

  @InjectMocks
  CalculadoraServiceImpl calculadoraService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void deberiaSumarDosNumeros() {
    // Preparación de datos de prueba
    List<BigDecimal> operandos = Arrays.asList(new BigDecimal("2"), new BigDecimal("3"));
    Operacion operacion = mock(Suma.class);
    when(operacionFactory.crearOperacion("suma")).thenReturn(operacion);
    when(operacion.calcular(operandos)).thenReturn(new BigDecimal("5"));

    // Ejecución del método a probar
    BigDecimal resultado = calculadoraService.calcular(operandos, "suma");

    // Comprobación del resultado
    Assertions.assertEquals(new BigDecimal("5"), resultado);
  }

  @Test
  void deberiaRestarDosNumeros() {
    // Preparación de datos de prueba
    List<BigDecimal> operandos = Arrays.asList(new BigDecimal("5"), new BigDecimal("3"));
    Operacion operacion = mock(Resta.class);
    when(operacionFactory.crearOperacion("resta")).thenReturn(operacion);
    when(operacion.calcular(operandos)).thenReturn(new BigDecimal("2"));

    // Ejecución del método a probar
    BigDecimal resultado = calculadoraService.calcular(operandos, "resta");

    // Comprobación del resultado
    Assertions.assertEquals(new BigDecimal("2"), resultado);
  }

  @Test
  void deberiarlanzarExcepcion() throws OperacionInvalidaException {
    // Preparación de datos de prueba
    String operador = "multiplicacion";
    when(operacionFactory.crearOperacion(operador)).thenThrow(new OperacionInvalidaException("Operacion invalida: " + operador));

    // Ejecución del método a probar y comprobación del resultado
    assertThatThrownBy(() -> calculadoraService.calcular(Arrays.asList(new BigDecimal("2"), new BigDecimal("3")), operador))
            .isInstanceOf(OperacionInvalidaException.class)
            .hasMessageContaining("Operacion invalida: " + operador);
  }
}
