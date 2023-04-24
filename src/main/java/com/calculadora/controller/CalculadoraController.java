package com.calculadora.controller;

import com.calculadora.service.CalculadoraService;
import io.corp.calculator.TracerImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
public class CalculadoraController {

   @Autowired
   CalculadoraService calculadoraService;
   
   @Autowired
    TracerImpl tracer;

    @Operation(summary = "Realiza una operación matemática con los operandos especificados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación realizada correctamente",content = @Content),
            @ApiResponse(responseCode = "400", description = "Los parámeteros introducidos no son correctos.",
                    content = @Content) })  
    @GetMapping(value = "/calculo")
    public ResponseEntity<BigDecimal> calcula(@Parameter(description = "Lista de números a utilizar en la operación")
                                                  @NotEmpty @RequestParam(name = "operando")  List<BigDecimal> operandos,
                                              @Parameter(description = "Tipo de operación a realizar: suma, resta")
                                               @NotBlank @RequestParam(name = "operacion") String operacion) {
 
        BigDecimal resultado = calculadoraService.calcular(operandos, operacion);
        tracer.trace(resultado);
        
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

}
