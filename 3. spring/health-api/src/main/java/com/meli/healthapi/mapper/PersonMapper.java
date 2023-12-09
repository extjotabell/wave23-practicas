package com.meli.healthapi.mapper;

import com.meli.healthapi.dto.PersonDTO;
import com.meli.healthapi.model.Person;

public class PersonMapper {

    public static PersonDTO personToPersonDTO(Person person){
        return new PersonDTO(person.getId(), person.getName(), person.getLastName(), person.getAge(), person.getSymptoms());
    }

    public static Person personDTOToPerson(PersonDTO personDTO){
        return new Person(personDTO.getId(), personDTO.getName(), personDTO.getLastName(), personDTO.getAge(), personDTO.getSymptoms());
    }



}
