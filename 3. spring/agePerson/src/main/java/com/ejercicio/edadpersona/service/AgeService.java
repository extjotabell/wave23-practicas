package com.ejercicio.edadpersona.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class AgeService {

    public Integer execute(Integer day, Integer month, Integer year) throws Exception {
        LocalDate dateActually = LocalDate.now();
        LocalDate datePerson = LocalDate.of(year, month, day);
        if (year < 1930) {
            throw new Exception("¿Acaso es usted Mirtha Legrand?");
        }
        if (datePerson.getYear() > dateActually.getYear()) {
            throw new Exception("¿Acaso ustesd viene del futuro?");
        }
        Integer age = (int) ChronoUnit.YEARS.between(datePerson, dateActually);
        return age;
    }
}
