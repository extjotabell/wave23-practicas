package com.itbootcamp.EjercicioEdad;

import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/api/calcularEdad")
public class EdadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){

        try{
            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            LocalDate hoy = LocalDate.now();
            Period edad = Period.between(fechaNacimiento, hoy);
            return edad.getYears();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
