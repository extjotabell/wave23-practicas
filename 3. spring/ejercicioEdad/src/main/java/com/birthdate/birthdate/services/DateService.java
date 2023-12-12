package com.birthdate.birthdate.services;

import com.birthdate.birthdate.entity.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.Period;

@Service
public class DateService {

    public Person createPerson(Integer day,Integer month,Integer year, String name){
        LocalDate birthDate = LocalDate.of(year,month,day);
        Person person = new Person(name,birthDate);
        return person;
    }
}
