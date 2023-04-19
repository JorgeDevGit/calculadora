package com.calculadora.service;

import java.math.BigDecimal;
import java.util.List;

public class Resta implements Operacion{
    @Override
    public BigDecimal calcular(List<BigDecimal> operandos) {
        BigDecimal resultado = operandos.get(0);
        for (int i = 1; i < operandos.size(); i++) {
            resultado = resultado.subtract(operandos.get(i));
        }
        return resultado;
    }
}
