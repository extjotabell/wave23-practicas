package com.bootcampmeli.deportistas.Controller;

import com.bootcampmeli.deportistas.Model.Deporte;
import com.bootcampmeli.deportistas.DTO.DeportesDisponiblesReponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeporteController {
    private List<Deporte> deportes = new ArrayList<>();

    public DeporteController() {
        this.deportes.add(new Deporte("Futbol", "Profesional"));
        this.deportes.add(new Deporte("Beisbol", "Profesional"));
        this.deportes.add(new Deporte("Volley", "Profesional"));
        this.deportes.add(new Deporte("Golf", "Semi-Profesional"));
        this.deportes.add(new Deporte("Tenis", "Amateur"));
        this.deportes.add(new Deporte("Futbol Americano", "Universitario"));
    }

    @GetMapping("/findSports")
    public ResponseEntity<?> findSports(){
        DeportesDisponiblesReponseDTO deportesDisponiblesReponseDTO = new DeportesDisponiblesReponseDTO();
        deportesDisponiblesReponseDTO.setDeportes(deportes);
        return new ResponseEntity<>(deportesDisponiblesReponseDTO, HttpStatus.OK);
    }
}
