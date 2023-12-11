package com.bootcamp.ejercicioDeportistas.controller;

import com.bootcamp.ejercicioDeportistas.dto.request.DeporteRequestDto;
import com.bootcamp.ejercicioDeportistas.dto.response.DeporteResponseDto;
import com.bootcamp.ejercicioDeportistas.dto.response.ErrorResponse;
import com.bootcamp.ejercicioDeportistas.model.Deporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/deportes")
public class DeporteController {


    @PostMapping
    public ResponseEntity<?> agregarDeporte(@RequestBody DeporteRequestDto nuevoDeporteDto){

        try{
            if(nuevoDeporteDto.getNombre() == null || nuevoDeporteDto.getNivel() == null){
                throw new MissingRequestValueException("Datos incompletos para agregar un nuevo deporte");
            }
            Deporte nuevoDeporte = new Deporte(nuevoDeporteDto.getNombre(), nuevoDeporteDto.getNivel());
            Deporte.agregarDeporte(nuevoDeporte);
            DeporteResponseDto nuevoDeporteResponse = new DeporteResponseDto(
                    nuevoDeporte.getNombre(),
                    nuevoDeporte.getNivel());
            return new ResponseEntity<>(nuevoDeporteResponse, HttpStatus.OK);
        }catch(MissingRequestValueException e){
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(new ErrorResponse("Ocurrió un error."));
        }
    }

    @GetMapping
    public ResponseEntity<?> mostrarDeportes(){
        try{
            List<DeporteResponseDto> listaDeportesResponse = new ArrayList<>();
            for(Deporte deporte : Deporte.getListaDeportes()){
                listaDeportesResponse.add(new DeporteResponseDto(deporte.getNombre(), deporte.getNivel()));
            }
            return new ResponseEntity<>(listaDeportesResponse, HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(new ErrorResponse("Ocurrió un error."));
        }
    }

    @GetMapping("/{nombreDeporte}")
    public ResponseEntity<?> buscarDeporte(@PathVariable String nombreDeporte){
        try{
            Deporte deporteEncontrado = Deporte.getListaDeportes().stream()
                    .filter(p -> p.getNombre().equals(nombreDeporte))
                    .findFirst()
                    .orElse(null);

            if(deporteEncontrado == null){
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(
                    new DeporteRequestDto(
                            deporteEncontrado.getNombre(),
                            deporteEncontrado.getNivel()
                    )
            );

        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(new ErrorResponse("Ocurrió un error."));
        }
    }

}
