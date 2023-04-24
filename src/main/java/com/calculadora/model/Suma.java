package com.calculadora.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Suma implements Operacion{
    @Override
    public BigDecimal calcular(List<BigDecimal> operandos) {
        return operandos.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
