package com.personajes.starwars.controller;

import com.personajes.starwars.dto.request.PersonajeDto;
import com.personajes.starwars.entity.Personaje;
import com.personajes.starwars.service.PersonajeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonajeControllerTest {
    @Mock
    PersonajeServiceImpl service;
    @InjectMocks
    PersonajeController controller;

    @Test
    void obtenerMatchesTest(){
        String pattern = "Darth";
        PersonajeDto p1 = new  PersonajeDto();
        p1.setName("Darth Vader");
        p1.setHeight(202);
        p1.setMass(136);
        p1.setGender("male");
        p1.setHomeworld("Tatooine");
        p1.setSpecies("Human");
        PersonajeDto p2 = new  PersonajeDto();
        p2.setName("Darth Maul");
        p2.setHeight(175);
        p2.setMass(80);
        p2.setGender("male");
        p2.setHomeworld("Dathomir");
        p2.setSpecies("Zabrak");
        List<PersonajeDto> personajes = List.of(p1, p2);
        when(service.findMatches(pattern)).thenReturn(personajes);
        ResponseEntity<?> response= controller.obtenerMatches(pattern);
        assertEquals(ResponseEntity.ok().body(personajes),response);

    }


}
