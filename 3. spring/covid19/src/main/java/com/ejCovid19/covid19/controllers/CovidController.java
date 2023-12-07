package com.ejCovid19.covid19.controllers;

import com.ejCovid19.covid19.dto.SintomaDTO;
import com.ejCovid19.covid19.dto.PersonaDTO;
import com.ejCovid19.covid19.dto.SintomaGravedadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class CovidController {

    private final List<SintomaDTO> sintomas = new ArrayList<>(Arrays.asList(
            new SintomaDTO(1, "Perdida de olfato", 2),
            new SintomaDTO(2, "Dolor de cabeza", 1),
            new SintomaDTO(3, "Fiebre", 3),
            new SintomaDTO(4, "Placas", 4)
    ));

    private final List<PersonaDTO> personas = new ArrayList<>(Arrays.asList(
            new PersonaDTO(1, "Marcos", "Costanzo", 25, sintomas),
            new PersonaDTO(2, "Jorge", "Perez", 82, new ArrayList<>()),
            new PersonaDTO(3, "Carlos", "Martinez", 73, sintomas),
            new PersonaDTO(4, "Roman", "Farias", 61, new ArrayList<>())
    ));

    @GetMapping("/findSymptom")
    ResponseEntity<List<SintomaDTO>> getSintomas() {
        return new ResponseEntity<>(sintomas, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    ResponseEntity<SintomaGravedadDTO> buscarSintoma(@PathVariable String name) {
        Optional<SintomaDTO> sintomaBuscado = sintomas.stream()
                                            .filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(name))
                                            .findFirst();

        if (sintomaBuscado.isPresent()) {
            SintomaGravedadDTO nivelGravedad = new SintomaGravedadDTO(sintomaBuscado.get().getNivelDeGravedad());

            return new ResponseEntity<>(nivelGravedad, HttpStatus.OK);
        }

        SintomaGravedadDTO noExiste = new SintomaGravedadDTO(-1);
        return new ResponseEntity<>(noExiste, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findRiskPerson")
    ResponseEntity<List<PersonaDTO>> obtenerPersonasRiesgo() {
        List<PersonaDTO> personasRiesgo = personas.stream()
                                            .filter(personaDTO -> personaDTO.getEdad() > 60 && !personaDTO.getSintomas()
                                            .isEmpty())
                                            .toList();

        return new ResponseEntity<>(personasRiesgo, HttpStatus.OK);
    }

}
