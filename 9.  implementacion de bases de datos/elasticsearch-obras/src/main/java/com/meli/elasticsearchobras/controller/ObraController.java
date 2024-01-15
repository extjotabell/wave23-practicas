package com.meli.elasticsearchobras.controller;

import com.meli.elasticsearchobras.domain.DTO.ObraDTO;
import com.meli.elasticsearchobras.service.IObraService;
import com.meli.elasticsearchobras.service.ObraServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obras")
public class ObraController {

    private final IObraService service;

    public ObraController(ObraServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ObraDTO obra) {
        return new ResponseEntity<>(service.save(obra), HttpStatus.CREATED);
    }

    @GetMapping("/find-by-autor/{autor}")
    public ResponseEntity<?> findByAutor(@PathVariable String autor) {
        return new ResponseEntity<>(service.findByAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/find-by-nombre/{nombre}")
    public ResponseEntity<?> findByNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(service.findByNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/paginas-greater-than/{paginas}")
    public ResponseEntity<?> findByPaginasGreaterThan(@PathVariable String paginas) {
        return new ResponseEntity<>(service.findByPaginasGreaterThan(paginas), HttpStatus.OK);
    }

    @GetMapping("/publicacion-before/{anio}")
    public ResponseEntity<?> findByPublicacionBefore(@PathVariable String anio) {
        return new ResponseEntity<>(service.findByPublicacionBefore(anio), HttpStatus.OK);
    }

    @GetMapping("/publicacion-after/{anio}")
    public ResponseEntity<?> findByPublicacionAfter(@PathVariable String anio) {
        return new ResponseEntity<>(service.findByPublicacionAfter(anio), HttpStatus.OK);
    }
w
    @GetMapping("/find-by-editorial/{editorial}")
    public ResponseEntity<?> findByEditorial(@PathVariable String editorial) {
        return new ResponseEntity<>(service.findByEditorial(editorial), HttpStatus.OK);
    }
}
