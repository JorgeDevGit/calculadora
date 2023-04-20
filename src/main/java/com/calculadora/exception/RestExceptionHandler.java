package com.calculadora.exception;

import com.calculadora.util.TracerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class RestExceptionHandler {

    @Autowired
    TracerConfiguration tracerConfiguration;
    
     @ExceptionHandler(OperacionInvalidaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleOperacionInvalidaException(OperacionInvalidaException e) {
         tracerConfiguration.getTracerImpl().trace("Se ha producido un error al procesar la petición: " + e.getMessage());
        ErrorDto error = new ErrorDto();
        error.setMensaje("Operación inválida: " + e.getMessage());
        error.setTraza(e.getStackTrace());
        return error;
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleMethodConstraintViolation(ConstraintViolationException e) {
        tracerConfiguration.getTracerImpl().trace("Se ha producido un error al procesar la petición: " + e.getMessage());
        ErrorDto error = new ErrorDto();
        error.setMensaje("Request incorrecta: " + e.getMessage());
        error.setTraza(e.getStackTrace());
        return error;
    }
    
}
