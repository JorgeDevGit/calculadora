package com.calculadora.exception;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ErrorDtoTest {

  @Test
  void testSetAndGetMensaje() {
    ErrorDto errorDto = new ErrorDto();
    String mensaje = "Error";
    errorDto.setMensaje(mensaje);
    assertEquals(mensaje, errorDto.getMensaje());
  }

  @Test
  void testSetAndGetTraza() {
    ErrorDto errorDto = new ErrorDto();
    StackTraceElement[] traza = Thread.currentThread().getStackTrace();
    errorDto.setTraza(traza);
    assertArrayEquals(traza, errorDto.getTraza());
  }

}