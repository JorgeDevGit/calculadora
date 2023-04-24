package com.calculadora.factory;

import com.calculadora.exception.OperacionInvalidaException;
import com.calculadora.model.Operacion;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class OperacionFactory {
    private final Map<String, Operacion> operaciones = new HashMap<>();
    public OperacionFactory(List<Operacion> operacionesList) {
        operacionesList.forEach(op -> operaciones.put(op.getClass().getSimpleName().toLowerCase(), op));
    }
    public Operacion crearOperacion(String operador) {
        return Optional.ofNullable(operaciones.get(operador))
                .orElseThrow(() -> new OperacionInvalidaException("Operacion invalida: " + operador));
    }
} 
