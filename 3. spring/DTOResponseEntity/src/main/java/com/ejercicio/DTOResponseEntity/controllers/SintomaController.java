package com.ejercicio.DTOResponseEntity.controllers;

import com.ejercicio.DTOResponseEntity.dtos.SintomaDTO;
import com.ejercicio.DTOResponseEntity.entities.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sintoma")
public class SintomaController {
    List<Sintoma> listaSintomas = new ArrayList<>();
    @GetMapping("/loadSymptom")
    public String loadSymptom(){
        for (int i = 1; i <= 10; i++) {
            String codigo = "S" + i;
            String nombre = "Síntoma " + i;
            int nivelDeGravedad = i;

            Sintoma sintoma = new Sintoma(codigo, nombre, nivelDeGravedad);
            listaSintomas.add(sintoma);
        }
        return "Sintomas cargados";
    }

    @GetMapping("/findSymptom")
    public List<SintomaDTO> obtenerSintomas(){
        List<SintomaDTO> sintomasDTO = new ArrayList<>();
        for(Sintoma sintoma : listaSintomas){
            SintomaDTO sintomaDTO = new SintomaDTO();
            sintomaDTO.setNombre(sintoma.getNombre());
            sintomaDTO.setNivel_de_gravedad(sintoma.getNivel_de_gravedad());

            sintomasDTO.add(sintomaDTO);
        }

        return sintomasDTO;
    }

    @GetMapping("findSymptom/{name}")
    public ResponseEntity<String> buscarSintoma(@PathVariable String name){
        Optional<Sintoma> result = listaSintomas.stream().filter(x -> x.getNombre().equals(name)).findFirst();

        return result.map(sintoma -> new ResponseEntity<>("El nivel de gravedad del sintoma " + name + " es " + sintoma.getNivel_de_gravedad(),
                HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("No se encontro ningun sintoma con ese nombre", HttpStatus.BAD_REQUEST));
    }


}
