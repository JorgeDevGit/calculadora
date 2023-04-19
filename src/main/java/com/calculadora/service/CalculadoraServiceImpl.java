package com.calculadora.service;

import com.calculadora.factory.OperacionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CalculadoraServiceImpl implements CalculadoraService{ 
    @Autowired 
    OperacionFactory operacionFactory;

    @Override
    public BigDecimal calcular(List<BigDecimal> operandos, String operador) {
        Operacion operacion = operacionFactory.crearOperacion(operador);
        return operacion.calcular(operandos);
    }
}
