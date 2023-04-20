package com.calculadora;

import com.calculadora.controller.CalculadoraController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CalculadoraApplicationTest {

    @Autowired
    private CalculadoraController calculadoraController;

    @Test
    void contextLoads() {
        assertThat(calculadoraController).isNotNull();
    }

}