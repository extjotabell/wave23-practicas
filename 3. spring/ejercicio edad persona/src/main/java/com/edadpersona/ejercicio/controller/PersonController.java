package com.edadpersona.ejercicio.controller;

import com.edadpersona.ejercicio.entities.Person;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.Period;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class PersonController {
    ArrayList<Person> persons = new ArrayList<Person>();
    Person ana = new Person("Ana", "Lopez", "2020-07-15");
    Person luis = new Person("Luis", "Sanchez", "1997-12-05");
    Person sol = new Person("Sol", "Martinez", "1980-03-21");

    public PersonController() {
        persons.add(ana);
        persons.add(luis);
        persons.add(sol);
    }

    @GetMapping(path = "/{day}/{month}/{year}")
    public int getUserBirthday(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        if (validate(day, month, year)) {
            return calculateUserBirthday(day, month, year);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fecha inválida.");
        }
    }

    @GetMapping(path = "/userInfo/{day}/{month}/{year}")
    public Person userInfo(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        if (validate(day, month, year)) {
            Person p = getUserInfo(day, month, year);
            if (p != null) {
                return p;
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrada.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fecha inválida.");
        }
    }

    private int calculateUserBirthday(int day, int month, int year) {
        String dobInput = String.format("%04d-%02d-%02d", year, month, day);
        LocalDate dob = LocalDate.parse(dobInput);
        LocalDate currentDate = LocalDate.now();
        return Period.between(dob, currentDate).getYears();
    }

    private boolean validate(int day, int month, int year){
        if (day <= 0 || month <= 0 || year <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private Person getUserInfo(int day, int month, int year){
        Person user = null;
        String dob = String.format("%04d-%02d-%02d", year, month, day);

        for (Person p : persons) {
            if (p.getDob().equals(dob)) {
                user = p;
            }
        }

        return user;
    }
}
