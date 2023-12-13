package com.pereiravilches.Concesionaria.controller;

import com.pereiravilches.Concesionaria.DTO.RequestVehiculoDTO;
import com.pereiravilches.Concesionaria.service.IConcesionariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("v1/api/vehicles/")
public class ConcesionariaController {

    @Autowired
    IConcesionariaService concesionariaService;

    @PostMapping
    //Agrega un nuevo vehículo.
    public ResponseEntity<?> agregarVehiculo(@RequestBody RequestVehiculoDTO RVehiculoDTO){
        return new ResponseEntity<>(concesionariaService.agregarVehiculo(RVehiculoDTO), HttpStatus.OK);
    }

    @GetMapping
    //Retorna un listado de todos los usados seleccionados. No incluye services.
    public ResponseEntity<?> getUsados(){
        return new ResponseEntity<>(concesionariaService.getUsados(), HttpStatus.OK);
    }

    @GetMapping("dates")
    //Retorna el listado de los vehículos según fecha de fabricación.
    public ResponseEntity<?> getVehiculosPorFechaDeFabricación(@RequestParam LocalDate since,
                                                               @RequestParam LocalDate to){
        return new ResponseEntity<>(concesionariaService.getVehiculosPorFechaDeFabricación(since,to), HttpStatus.OK);
    }

    @GetMapping("prices")
    //Muestra el listado de los vehículos según los precios dados.
    public ResponseEntity<?> getVehiculosPorPrecio(@RequestParam Integer since,
                                                   @RequestParam Integer to){
        return new ResponseEntity<>(concesionariaService.getVehiculosPorPrecio(since,to), HttpStatus.OK);
    }

    @GetMapping("{id}")
    //Muestra toda la información relacionada con el vehículo.
    public ResponseEntity<?> getVehiculoById(@PathVariable Integer id){
        return new ResponseEntity<>(concesionariaService.getVehiculoById(id), HttpStatus.OK);
    }
}
