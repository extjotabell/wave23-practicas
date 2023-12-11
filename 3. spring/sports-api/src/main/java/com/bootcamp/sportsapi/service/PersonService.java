package com.bootcamp.sportsapi.service;

import com.bootcamp.sportsapi.dto.PersonDTO;
import com.bootcamp.sportsapi.model.Person;
import com.bootcamp.sportsapi.model.Sport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private List<Person> persons = new ArrayList<>();


    public List<PersonDTO> getPersons(){
        if (persons.isEmpty()) this.loadPersons();
        return persons.stream().map(p-> new PersonDTO(p.getName(), p.getLastName(),p.getSports().stream().map(Sport::getName)
                .toList())).toList();
    }

    private void loadPersons() {
        Sport football = new Sport("Football", "Beginner");
        Sport basket = new Sport("Basket", "Beginner");
        Sport tennis = new Sport("Tennis", "Professional");

        Person personOne = new Person(1000, "Juan", "Lopez", 24, List.of(football, basket));
        Person personTwo = new Person(1000, "Loren", "Vargas", 49, List.of(tennis, basket));

        persons.addAll(List.of(personOne, personTwo));

    }

}