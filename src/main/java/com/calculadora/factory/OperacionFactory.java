package com.calculadora.factory;

import com.calculadora.exception.OperacionInvalidaException;
import com.calculadora.service.Operacion;
import com.calculadora.service.Resta;
import com.calculadora.service.Suma;
import org.springframework.stereotype.Component;

    @Component
    public class OperacionFactory {
        public Operacion crearOperacion(String operador) {
            switch (operador) {
                case "suma":
                    return new Suma();
                case "resta":
                    return new Resta();
                default:
                    throw new OperacionInvalidaException("Operacion invalida: " + operador);
            }
        }
    }
