package com.calculadora.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Resta implements Operacion{
    @Override
    public BigDecimal calcular(List<BigDecimal> operandos) {
        return operandos.stream().skip(1).reduce(operandos.get(0), BigDecimal::subtract);
    }
}
