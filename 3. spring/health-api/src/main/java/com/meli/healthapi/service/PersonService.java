package com.meli.healthapi.service;

import com.meli.healthapi.mapper.PersonMapper;
import com.meli.healthapi.model.Person;
import org.springframework.stereotype.Service;
import com.meli.healthapi.dto.PersonDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    List<Person> persons;

    public PersonService(){
        persons = new ArrayList<>();
    }

    public PersonService(List<Person> persons) {
        this.persons = persons;
    }

    public List<PersonDTO> getPersons() {
        return persons.stream().map(PersonMapper::personToPersonDTO).toList();
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(PersonDTO p) {
        persons.add(PersonMapper.personDTOToPerson(p));
    }
}
