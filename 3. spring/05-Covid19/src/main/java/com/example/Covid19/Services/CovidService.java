package com.example.Covid19.Services;

import com.covid.sintomas.DTOS.PersonasSintomasDTO;
import com.covid.sintomas.DTOS.SintomaDTO;
import com.covid.sintomas.Entities.Persona;
import com.covid.sintomas.Entities.Sintoma;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CovidService {

    private final Map<Persona, List<Sintoma>> sintomasPersonas = new HashMap<>();

    public CovidService() {
        sintomasPersonas.put(Persona.personas.get(0),new ArrayList<>(List.of(Sintoma.sintomas.get(2))));
        sintomasPersonas.put(Persona.personas.get(1),new ArrayList<>(List.of()));
        sintomasPersonas.put(Persona.personas.get(2),new ArrayList<>(List.of(Sintoma.sintomas.get(4), Sintoma.sintomas.get(3))));
        sintomasPersonas.put(Persona.personas.get(3),new ArrayList<>(List.of(Sintoma.sintomas.get(0), Sintoma.sintomas.get(1))));
    }

    public List<PersonasSintomasDTO> generarListaPersonasRiesgoYSintomas() {
        return sintomasPersonas.entrySet().stream().filter(entry -> entry.getKey().getEdad() > 60 && !entry.getValue().isEmpty()).map(CovidService::mapAPersonaDTO).toList();
    }

    private static SintomaDTO convierteSintomaADTO(Sintoma sintoma) {
        return new SintomaDTO(sintoma.getNombre(),
                switch (sintoma.getNivelDeGravedad()) {
                    case 1 -> "Bajo";
                    case 2 -> "Medio";
                    case 3 -> "Alto";
                    default -> "Desconocido";
                });
    }

    public SintomaDTO buscarSintomaPorNombre(String name) {
        return CovidService.convierteSintomaADTO(Sintoma.sintomas.stream().filter(sintoma ->
                sintoma.getNombre().equals(name)).findFirst().get());
    }

    private static PersonasSintomasDTO mapAPersonaDTO(Map.Entry<Persona, List<Sintoma>> entry) {
        Persona persona = entry.getKey();
        List<Sintoma> sintomas = entry.getValue();
        return new PersonasSintomasDTO(persona.getNombre() + " " + persona.getApellido(), sintomas.stream().map(CovidService::convierteSintomaADTO).toList());
    }

    public List<SintomaDTO> generarListaSintomas() {
        return Sintoma.sintomas.stream().map(CovidService::convierteSintomaADTO).toList();
    }
}