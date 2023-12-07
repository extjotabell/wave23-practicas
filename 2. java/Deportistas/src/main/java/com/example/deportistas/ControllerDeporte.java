package com.example.deportistas;

import com.example.deportistas.models.Deporte;
import com.example.deportistas.models.DeporteDTO;
import com.example.deportistas.models.Persona;
import com.example.deportistas.models.PersonaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerDeporte {
    private final List<Deporte> deportes = List.of(
            new Deporte("NATACION", "PRINCIPIANTE"),
            new Deporte("FUTBOL", "AVANZADO"),
            new Deporte("DANZA", "INTERMEDIO")
    );
    private final List<Persona> personas = List.of(
            new Persona("Juan", "Perez", 40, deportes.get(1)),
            new Persona("Maria", "Gonzales", 34, deportes.get(0))
    );

    @GetMapping("/findSports")
    public ResponseEntity<?> deportes() {
        List<DeporteDTO> deportesDto = deportes.stream().map(deporte -> new DeporteDTO(deporte.getNombre(), deporte.getNivel())).toList();
        return ResponseEntity.status(200).body(deportesDto);
    }

    @GetMapping("/findSports/{deporte}")
    public ResponseEntity<?> deportes(@PathVariable String deporte) {
        DeporteDTO deporteDTO = deportes.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(deporte))
                .findFirst()
                .map(d -> new DeporteDTO(d.getNombre(), d.getNivel()))
                .orElse(null);
        if (deporteDTO == null) {
            return ResponseEntity.status(404).body("No existe ningun deporte llamado " + deporte);
        }
        return ResponseEntity.status(200).body(deporteDTO.getNivel());
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> personasDeportistas() {
        List<PersonaDTO> personasDTO = personas.stream()
                .filter(persona -> persona.getDeporte() != null)
                .map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre()))
                .toList();
        return ResponseEntity.ok(personasDTO);
    }


}
