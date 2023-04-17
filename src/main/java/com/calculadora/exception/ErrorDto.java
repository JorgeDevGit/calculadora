package com.calculadora.exception;

public class ErrorDto {

    private String mensaje;
    private StackTraceElement[] traza;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public StackTraceElement[] getTraza() {
        return traza;
    }

    public void setTraza(StackTraceElement[] traza) {
        this.traza = traza;
    }
}