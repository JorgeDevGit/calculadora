package com.calculadora.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class RestExceptionHandler {

     @ExceptionHandler(OperacionInvalidaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleOperacionInvalidaException(OperacionInvalidaException e) {
        ErrorDto error = new ErrorDto();
        error.setMensaje("Operación inválida: " + e.getMessage());
        error.setTraza(e.getStackTrace());
        return error;
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleMethodConstraintViolation(ConstraintViolationException e) {
        ErrorDto error = new ErrorDto();
        error.setMensaje("Request incorrecta: " + e.getMessage());
        error.setTraza(e.getStackTrace());
        return error;
    }
    
}