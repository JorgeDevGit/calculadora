package com.calculadora.util;

import java.math.BigDecimal;
import java.util.List;

public class Operaciones {
    
    public static BigDecimal suma(List<BigDecimal> operandos){
        return operandos.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    public static BigDecimal resta (List<BigDecimal> operandos){
        BigDecimal resultado = operandos.get(0);
        for (int i = 1; i < operandos.size(); i++) {
            resultado = resultado.subtract(operandos.get(i));
        }
        return resultado;
    }
}
