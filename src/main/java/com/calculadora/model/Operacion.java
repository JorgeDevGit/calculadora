package com.calculadora.model;

import java.math.BigDecimal;
import java.util.List;

public interface Operacion {
    BigDecimal calcular(List<BigDecimal> operandos);
}
