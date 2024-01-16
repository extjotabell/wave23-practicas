package spring.apiclothing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.apiclothing.dto.ClothingDto;
import spring.apiclothing.service.IClothingService;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {

    @Autowired
    IClothingService service;

    //POST
    ///api/clothes
    //Crear una nueva prenda.
    @PostMapping
    public ResponseEntity<?> newPrenda(@RequestBody ClothingDto prenda){
        return new ResponseEntity<>(service.saveNewPrenda(prenda), HttpStatus.CREATED);
    }

    //GET
    ///api/clothes
    //Devolver todas las prendas
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    //GET
    ///api/clothes/{code}
    //Devolver una prenda en particular
    @GetMapping("/{code}")
    public ResponseEntity<?> getByCode(@PathVariable Long code){
        return new ResponseEntity<>(service.getById(code), HttpStatus.OK);
    }

    //PUT
    ///api/clothes/{code}
    //Actualizar una prenda en particular
    @PutMapping ("/{code}")
    public ResponseEntity<?> update(
            @PathVariable Long code,
            @RequestBody ClothingDto prenda){
        return new ResponseEntity<>(service.updatePrenda(code, prenda), HttpStatus.OK);
    }

    //DELETE
    ///api/clothes/{code]
    //Eliminar una prenda en particular
    @DeleteMapping ("/{code}")
    public ResponseEntity<?> delete(@PathVariable Long code){
        return new ResponseEntity<>(service.deletePrenda(code), HttpStatus.OK);
    }

    //GET
    ///api/clothes/{size}
    //Traer todas las prendas de un determinado talle
    @GetMapping("/size/{size}")
    public ResponseEntity<?> getByCode(@PathVariable Integer size){
        return new ResponseEntity<>(service.getByTalle(size), HttpStatus.OK);
    }

    //GET
    ///api/clothes/?name=remera
    //Buscar todas las prendas en cuyo nombre aparezca la palabra “remera”. No se tienen en cuenta ni mayúsculas ni minúsculas
    @GetMapping("/")
    public ResponseEntity<?> getByCode(@RequestParam String name){
        return new ResponseEntity<>(service.getByNombre(name), HttpStatus.OK);
    }

}
