package com.calculadora.exception;

public class OperacionInvalidaException extends RuntimeException{
    public OperacionInvalidaException(String mensaje) {
        super(mensaje);
    }
    
}
