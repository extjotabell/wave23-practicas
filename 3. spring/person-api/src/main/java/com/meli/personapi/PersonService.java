package com.meli.personapi;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class PersonService {

    public int calculateAge(int day, int month, int year){
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, month, day);
        Period age = Period.between(birthDate, currentDate);
        return age.getYears();
    }
}
