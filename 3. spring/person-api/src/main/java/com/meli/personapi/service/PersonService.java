package com.meli.personapi.service;

import com.meli.personapi.dto.request.PersonDTO;
import com.meli.personapi.dto.response.PersonResponseDTO;
import com.meli.personapi.exception.PERSONEXCEPTION;
import com.meli.personapi.model.Person;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    List<Person> persons = new ArrayList<>();

    public int calculateAge(int day, int month, int year) throws PERSONEXCEPTION {
        try {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, month, day);
        Period age = Period.between(birthDate, currentDate);
        return age.getYears();
        }catch(DateTimeException e){
            throw  new PERSONEXCEPTION(PERSONEXCEPTION.ILLEGAL_ARGUMENT);
        }
    }

    public List<PersonResponseDTO> addPerson(PersonDTO personDTO) throws PERSONEXCEPTION {
        try {
            LocalDate birthDate = LocalDate.of(personDTO.getYear(), personDTO.getMonth(), personDTO.getDay());
            Person person = new Person(personDTO.getName(), personDTO.getLastName(), birthDate,
                    this.calculateAge(personDTO.getDay(), personDTO.getMonth(), personDTO.getYear()));
            persons.add(person);
            return this.getPersons();
        }catch(DateTimeException e){
            throw  new PERSONEXCEPTION(PERSONEXCEPTION.ILLEGAL_ARGUMENT);
        }
    }

    public List<PersonResponseDTO> getPersons(){
       return  persons.stream().map( p -> new PersonResponseDTO(p.getName(), p.getLastName(), p.getAge())).toList();
    }
}
