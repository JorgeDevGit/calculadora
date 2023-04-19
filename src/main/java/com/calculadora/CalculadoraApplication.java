package com.calculadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.calculadora.controller",
		"com.calculadora.service","com.calculadora.exception",
		"com.calculadora.factory","com.calculadora.util"})
public class CalculadoraApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CalculadoraApplication.class, args);
	}

}
