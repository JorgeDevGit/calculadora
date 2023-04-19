package com.calculadora.service;

import java.math.BigDecimal;
import java.util.List;

public class Suma implements Operacion{
    @Override
    public BigDecimal calcular(List<BigDecimal> operandos) {
        return operandos.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
