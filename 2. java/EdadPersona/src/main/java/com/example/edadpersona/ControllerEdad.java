package com.example.edadpersona;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/edad")
public class ControllerEdad {
    @GetMapping("/{dia}/{mes}/{anio}")
    public long edadPersona(@PathVariable String dia, @PathVariable String mes, @PathVariable String anio) {
        LocalDate fechaNacimiento = LocalDate.of(Integer.parseInt(anio),Integer.parseInt(mes),Integer.parseInt(dia));
        LocalDate now = LocalDate.now();
        return ChronoUnit.YEARS.between(fechaNacimiento,now);
    }
}
