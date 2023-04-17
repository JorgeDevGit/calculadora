package com.calculadora.controller;

import com.calculadora.service.CalculadoraService;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculadoraController {

   @Autowired
   CalculadoraService calculadoraService;
   
    @GetMapping(value = "/calculo")
    public ResponseEntity<BigDecimal> calcula(@RequestParam(name = "operando") List<BigDecimal> operandos,
                                          @RequestParam(name = "operacion") String operacion) {
                
        BigDecimal resultado = calculadoraService.calcular(operandos, operacion);
        
        TracerImpl tracer = new TracerImpl();
        tracer.trace(resultado);
        
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

}
