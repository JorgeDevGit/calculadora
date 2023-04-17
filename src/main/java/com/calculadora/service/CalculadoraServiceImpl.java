package com.calculadora.service;

import com.calculadora.exception.OperacionInvalidaException;
import com.calculadora.util.Operaciones;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CalculadoraServiceImpl implements CalculadoraService{

    @Override
    public BigDecimal calcular(List<BigDecimal> operandos, String operador) {
        
        switch (operador){
            case "suma":
                return Operaciones.suma(operandos);
            case "resta":
               return Operaciones.resta(operandos);
            default:
                throw new OperacionInvalidaException("La operacion " +  operador + " no está permitida");
        }
        
    }
}
