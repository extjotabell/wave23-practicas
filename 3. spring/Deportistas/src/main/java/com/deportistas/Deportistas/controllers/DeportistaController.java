package com.deportistas.Deportistas.controllers;

import com.deportistas.Deportistas.dto.DeporteDTO;
import com.deportistas.Deportistas.dto.DeporteNivelDTO;
import com.deportistas.Deportistas.dto.PersonaDTO;
import com.deportistas.Deportistas.dto.PersonaDeporteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class DeportistaController {

    private List<DeporteDTO> deportes = new ArrayList<>();
    private Map<PersonaDTO, List<DeporteDTO>> deportistas = new HashMap<>();

    @GetMapping("/findSports")
    ResponseEntity<List<DeporteDTO>> getDeportes() {
        cargarDatos();

        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    ResponseEntity<DeporteNivelDTO> getDeportePorNombre(@PathVariable String name) {
        cargarDatos();

        String nivel = this.deportes.stream()
                            .filter(d -> d.getNombre().equalsIgnoreCase(name))
                            .map(DeporteDTO::getNivel)
                            .findFirst()
                            .get();
        return new ResponseEntity<>(new DeporteNivelDTO(nivel), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    ResponseEntity<List<PersonaDeporteDTO>> getDeportistas() {
        cargarDatos();

        List<PersonaDeporteDTO> personasDeportes = new ArrayList<>();

        for (Map.Entry<PersonaDTO, List<DeporteDTO>> entry : deportistas.entrySet()) {
            for (DeporteDTO d : entry.getValue()) {
                personasDeportes.add(new PersonaDeporteDTO(entry.getKey().getNombre(), entry.getKey().getApellido(), d.getNombre()));
            }
        }

        return new ResponseEntity<>(personasDeportes, HttpStatus.OK);
    }

    private void cargarDatos(){
        DeporteDTO futbol = new DeporteDTO("Futbol", "Principiante");
        DeporteDTO basket = new DeporteDTO("Basket", "Principiante");
        DeporteDTO tennis = new DeporteDTO("Tennis", "Profesional");
        deportes.addAll(List.of(futbol, basket, tennis));

        PersonaDTO persona = new PersonaDTO("Juan", "Lopez");
        PersonaDTO personaDos= new PersonaDTO("Emilia", "Lopez");

        deportistas.put(persona, List.of(futbol, tennis, basket));
        deportistas.put(personaDos, List.of(tennis, basket));
    }

}
