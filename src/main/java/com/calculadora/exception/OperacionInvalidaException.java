package com.calculadora.exception;

public class OperacionInvalidaException extends RuntimeException{

    private static final long serialVersionUID = 3022304024465779987L;

    public OperacionInvalidaException(String mensaje) {
        super(mensaje);
    }
    
}
