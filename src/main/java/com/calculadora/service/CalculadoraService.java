package com.calculadora.service;

import java.math.BigDecimal;
import java.util.List;

public interface CalculadoraService {
    BigDecimal calcular(List<BigDecimal> operandos, String operador);
}
