package com.example.covid.services;

import com.example.covid.dto.PersonasRiesgoDTO;
import com.example.covid.dto.SymptomDTO;
import com.example.covid.dto.SymptomListDTO;
import com.example.covid.entities.Gravedad;
import com.example.covid.entities.Persona;
import com.example.covid.entities.Sintoma;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CovidServices {
    private List<Sintoma> sintomas;
    private List<Persona> personas;

    public CovidServices() {
        sintomas = List.of(
                new Sintoma("Cod1", "Nom1", Gravedad.ALTA),
                new Sintoma("Cod2", "Nom2", Gravedad.MEDIA),
                new Sintoma("Cod3", "Nom3", Gravedad.MEDIA_ALTA),
                new Sintoma("Cod4", "Nom4", Gravedad.LETAL),
                new Sintoma("Cod5", "Nom5", Gravedad.BAJA)
        );

        personas = List.of(
                new Persona(1, "Nom1", "Ap1", 70, List.of(sintomas.get(0), sintomas.get(2))),
                new Persona(2, "Nom2", "Ap2", 20, List.of(sintomas.get(1), sintomas.get(2))),
                new Persona(3, "Nom3", "Ap3", 70, List.of(sintomas.get(4), sintomas.get(3))),
                new Persona(4, "Nom4", "Ap4", 20, List.of(sintomas.get(2), sintomas.get(1))),
                new Persona(5, "Nom5", "Ap5", 20, List.of(sintomas.get(4), sintomas.get(2)))
        );
    }
    public SymptomListDTO findSymptoms() {
        return new SymptomListDTO(sintomas.stream()
                .map(s -> new SymptomListDTO.SymptomDTO(s.getCodigo(), s.getNombre(), s.getGravedad())).toList());
    }

    public Optional<SymptomDTO> findSymptom(String name) {
        Optional<Sintoma> sintoma = sintomas.stream()
                .filter(s -> s.getNombre().equalsIgnoreCase(name)).findFirst();

        return sintoma.map(s -> new SymptomDTO(s.getGravedad()));
    }

    public PersonasRiesgoDTO findRiskPersons() {
        List<Persona> personasRiesgo = personas.stream().
                filter(p -> p.getEdad() > 60 && p.getSintomas().stream()
                        .anyMatch(s -> s.getGravedad().equals(
                                Gravedad.ALTA) || s.getGravedad().equals(Gravedad.LETAL))).toList();

        return new PersonasRiesgoDTO(personasRiesgo.stream()
                .map(p -> new PersonasRiesgoDTO.PersonaRiesgoDTO(p.getNombre(), p.getApellido())).toList());
    }
}
