package spring.apiclothing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.apiclothing.dto.SalesDto;
import spring.apiclothing.service.IClothingService;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/sale")
public class SalesController {

    @Autowired
    IClothingService service;

    //POST
    ///api/sale
    //Crear una nueva venta.
    @PostMapping
    public ResponseEntity<?> newVenta(@RequestBody SalesDto venta){
        return new ResponseEntity<>(service.saveNewVenta(venta), HttpStatus.CREATED);
    }

    //GET
    ///api/sale
    //Devolver todas las ventas
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAllVentas(), HttpStatus.OK);
    }

    //GET
    ///api/sale/{number}
    //Devolver una venta en particular
    @GetMapping("/{number}")
    public ResponseEntity<?> getByCode(@PathVariable Long number){
        return new ResponseEntity<>(service.getVentaById(number), HttpStatus.OK);
    }

    //PUT
    ///api/sale/{number}
    //Actualizar una venta en particular
    @PutMapping ("/{code}")
    public ResponseEntity<?> update(
            @PathVariable Long code,
            @RequestBody SalesDto venta){
        return new ResponseEntity<>(service.updateVenta(code, venta), HttpStatus.OK);
    }

    //DELETE
    ///api/sale/{number]
    //Eliminar una venta en particular
    @DeleteMapping ("/{number}")
    public ResponseEntity<?> delete(@PathVariable Long number){
        return new ResponseEntity<>(service.deleteVenta(number), HttpStatus.OK);
    }

    //GET
    ///api/sale?date=22/05/2022
    //Traer todas las prendas de una determinada fecha
    @GetMapping("/")
    public ResponseEntity<?> getByDate(@RequestParam LocalDate date){
        return new ResponseEntity<>(service.getByDate(date), HttpStatus.OK);
    }

    //GET
    ///api/sale/clothes/{number}
    //Traer la lista completa de prendas de una determinada venta.
    @GetMapping("/clothes/{number}")
    public ResponseEntity<?> getPrendas(@PathVariable Long number){
        return new ResponseEntity<>(service.getPrendasByVenta(number), HttpStatus.OK);
    }

    //TODO: Unir métodos con variables opcionales
    //TODO: Manejar excepciones
    //TODO: Mejorar respuestas DTO
}
