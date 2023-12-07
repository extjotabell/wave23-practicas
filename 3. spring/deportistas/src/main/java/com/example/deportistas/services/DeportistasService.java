package com.example.deportistas.services;

import com.example.deportistas.dto.DeporteDTO;
import com.example.deportistas.dto.DeportesDTO;
import com.example.deportistas.dto.PersonaDTO;
import com.example.deportistas.dto.PersonasDTO;
import com.example.deportistas.entities.Deporte;
import com.example.deportistas.entities.Persona;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeportistasService {
    private List<Persona> personas;
    private List<Deporte> deportes;

    public DeportistasService() {
        deportes = List.of(
                new Deporte("Futbol", "10"),
                new Deporte("Basketball", "15"),
                new Deporte("Beisball", "20")
        );

        personas = List.of(
               new Persona("A", "B", 20, deportes.get(0)),
               new Persona("C", "D", 20, deportes.get(1)),
               new Persona("E", "F", 20, deportes.get(2))
        );
    }

    public PersonasDTO getPersonas() {
        return new PersonasDTO(personas.stream()
                .map(persona ->
                        new PersonaDTO(persona.getNombre(), persona.getNombre(),
                                persona.getDeporte().getNombre())).toList());
    }

    public DeportesDTO getDeportes() {
        return new DeportesDTO(deportes);
    }

    public Optional<DeporteDTO> getDeporte(String nombre) {
        Optional<Deporte> deporte = deportes.stream().filter(d -> d.getNombre().equals(nombre)).findFirst();
        return deporte.map(value -> new DeporteDTO(value.getNivel()));
    }

}
