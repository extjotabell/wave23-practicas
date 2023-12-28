package com.personajes.starwars.repository;

import com.personajes.starwars.entity.Personaje;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class PersonajeRepositoryTest {
    @Autowired
    PersonajeRepositoryImpl repository;

    @Test
    public void findAllTest(){
        List<Personaje> personajes = repository.findAll();
        assertNotEquals(personajes.size(),0);
    }

}
