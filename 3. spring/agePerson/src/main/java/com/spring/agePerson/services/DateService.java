package com.spring.agePerson.services;

import com.spring.agePerson.entities.Person;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DateService {
    public Person createPerson(Integer day, Integer month, Integer year, String name){
        LocalDate birthDate = LocalDate.of(year,month,day);
        Person person = new Person(name,birthDate);
        return person;
    }
}
