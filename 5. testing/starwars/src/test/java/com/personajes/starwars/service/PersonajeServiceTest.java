package com.personajes.starwars.service;

import com.personajes.starwars.dto.request.PersonajeDto;
import com.personajes.starwars.entity.Personaje;
import com.personajes.starwars.repository.IPersonajeRepository;
import com.personajes.starwars.repository.PersonajeRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonajeServiceTest {
    @Mock
    PersonajeRepositoryImpl repository;
    @InjectMocks
    PersonajeServiceImpl service;

    @Test
    public void findMatches() {
        Personaje p1 = new Personaje();
        p1.setName("Darth Vader");
        p1.setHeight(202);
        p1.setMass(136);
        p1.setGender("male");
        p1.setHomeWorld("Tatooine");
        p1.setSpecies("Human");
        Personaje p2 = new Personaje();
        p2.setName("Darth Maul");
        p2.setHeight(175);
        p2.setMass(80);
        p2.setGender("male");
        p2.setHomeWorld("Dathomir");
        p2.setSpecies("Zabrak");
        List<Personaje> personajes = List.of(p1, p2);
        when(repository.findAll()).thenReturn(personajes);
        List<PersonajeDto> personajeDtos = service.findMatches("Darth");

        for (PersonajeDto p : personajeDtos) {
            Assertions.assertTrue(p.getName().contains("Darth"));
        }
    }

}
