package com.mercadolibre.deportistas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.deportistas.dto.PersonDTO;
import com.mercadolibre.deportistas.dto.SportDTO;
import com.mercadolibre.deportistas.entity.Person;
import com.mercadolibre.deportistas.entity.Sport;
import com.mercadolibre.deportistas.reposotory.PersonRepositoryImpl;
import com.mercadolibre.deportistas.reposotory.SportRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeportistaServiceImpl implements IDeportistaService {

    @Autowired
    SportRepositoryImpl sportsRepo;
    @Autowired
    PersonRepositoryImpl personRepo;
    @Override
    public List<SportDTO> findSports() {
        List<Sport> sports = this.sportsRepo.findAll();
        return sports.stream().map(sport -> new ObjectMapper().convertValue(sport,SportDTO.class)).toList();
    }

    @Override
    public List<String> findSport(String name) {
        return this.sportsRepo.getLevelsBySportName(name);
    }

    @Override
    public List<PersonDTO> findSportsPersons() {
        List<Person> persons = this.personRepo.findAll();
        List<PersonDTO> response = new ArrayList<>();

        for (Person person: persons) {
            response.add( new PersonDTO(
                            person.getName(),
                            person.getLastname(),
                            new SportDTO(person.getSport().getName())));
        }

        return response;
    }
}
