package com.deportistas.deportistas.controller;
import com.deportistas.deportistas.dto.*;
import com.deportistas.deportistas.model.Deporte;
import com.deportistas.deportistas.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeporteController {
    List<Deporte> deportes;
    Map<String, Persona> deportistas;

    public DeporteController() {
        deportes = new ArrayList<>();
        deportes.add(new Deporte("Handball", "Bajo"));
        deportes.add(new Deporte("Football", "Medio"));
        deportes.add(new Deporte("Volleyball", "Alto"));

        deportistas = new HashMap<>();
        deportistas.put("Handball", new Persona("Nomnbre 1", "Apellido 1", 20));
        deportistas.put("Football", new Persona("Nomnbre 2", "Apellido 2", 20));
        deportistas.put("Volleyball", new Persona("Nomnbre 3", "Apellido 3", 20));
    }

    @GetMapping("/findSports")
    public ResponseEntity<DeportesResponseDTO>getDeportes(){
        List<DeporteDTO> deportesDto = new ArrayList<>();
        for (Deporte deporte:deportes){
            deportesDto.add(new DeporteDTO(deporte.getNivel(), deporte.getNombre()));
        }
        DeportesResponseDTO response = new DeportesResponseDTO(deportesDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?>getDeportesNombre(@PathVariable String name){
        DeporteDTO response = new DeporteDTO();
        for (Deporte d : deportes){
            if (d.getNombre().equals(name)){
                return ResponseEntity.ok(new DeporteDTO(d.getNivel(),d.getNombre()));
            }
        }
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Deporte no encontrado"),HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> getDeportesPersona() {
        List<DeportistaDTO> deportistasDto = new ArrayList<>();

        deportistas.forEach((key, persona) -> deportistasDto
                .add(new DeportistaDTO(persona.getNombre(), persona.getApellido(), key)));

        DeportistaResponseDTO response = new DeportistaResponseDTO(deportistasDto);
        return ResponseEntity.ok(response);
    }
}
