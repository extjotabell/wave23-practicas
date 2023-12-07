package com.meli.ejercicioDeportistas.repository;

import com.meli.ejercicioDeportistas.model.Deporte;
import com.meli.ejercicioDeportistas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository {
    public List<Persona> getAllPersonas(){
        return new ArrayList<>(){{
            add(new Persona("Juan", "Perez", 25, List.of(
                    new Deporte("Basket", "Avanzado"),
                    new Deporte("Futbol", "Intermedio"),
                    new Deporte("Hockey", "Avanzado")
            )));
            add(new Persona("Diego", "Hernandez", 25, List.of(
                    new Deporte("Boxeo", "Avanzado"),
                    new Deporte("Ping pong", "Intermedio"),
                    new Deporte("Hockey", "Principiante")
            )));
            add(new Persona("Jose", "Gonzales", 25, List.of(
                    new Deporte("Golf", "Principiante"),
                    new Deporte("Futbol", "Intermedio"),
                    new Deporte("Hockey", "Principiante")
            )));
        }};
    }
}
