package com.meli.edad.controllers;

import com.meli.edad.models.PersonRequest;
import com.meli.edad.models.PersonResponse;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AgeRestController {

    @PostMapping("/age")
    public PersonResponse getAge(@RequestBody PersonRequest request) {
        // Variables
        LocalDate birthDate;
        int age;

        // Handle invalid request (null values or negative date values)
        if (request.getName() == null ||
            request.getLastName() == null ||
            request.getBirthYear() <= 0 ||
            request.getBirthMonth() <= 0 ||
            request.getBirthDay() <= 0
        ) return null;

        // Handle invalid date
        try {
            birthDate = LocalDate.of(
                request.getBirthYear(),
                request.getBirthMonth(),
                request.getBirthDay()
            );
        } catch (DateTimeException e) {
            return null;
        }

        // Handle invalid age (Future birthDate)
        if (birthDate.isAfter(LocalDate.now())) return null;

        // Calculate age and return response
        age = Period.between(birthDate, LocalDate.now()).getYears();

        return new PersonResponse(
            request.getName(),
            request.getLastName(),
            birthDate,
            age
        );
    }

    @GetMapping("/persons")
    public List<PersonResponse> getPersons() {
        return PersonResponse.getPersonsList();
    }
}
