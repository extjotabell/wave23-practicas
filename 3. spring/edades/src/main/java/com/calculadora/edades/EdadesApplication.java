package com.calculadora.edades;

import com.calculadora.edades.controller.CalculadoraEdad;
import com.calculadora.edades.entities.Persona;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class EdadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdadesApplication.class, args);

	}

}
