package com.meli.ObrasLiterarias.controller;

import com.meli.ObrasLiterarias.dto.ObraDto;
import com.meli.ObrasLiterarias.dto.MessageDto;
import com.meli.ObrasLiterarias.service.ObraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraController {

    private final ObraService service;

    public ObraController(ObraService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<ObraDto> create(@RequestBody ObraDto obraDto) {
        ObraDto empleado = service.save(obraDto);
        return ResponseEntity.ok(empleado);
    }

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<ObraDto> empleados = service.findAll();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        ObraDto empleado = service.findById(id);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        service.deleteById(id);
        MessageDto message = new MessageDto("Empleado eliminado");
        return ResponseEntity.ok(message);
    }


    @GetMapping("/searchByAuthor/{author}")
    public ResponseEntity<?> searchByAuthor(@PathVariable String author) {
        List<ObraDto> obras = service.findByAuthor(author);
        return ResponseEntity.ok(obras);
    }

    @GetMapping("/searchByTitulo/{titulo}")
    public ResponseEntity<?> searchByTitulo(@PathVariable String titulo) {
        List<ObraDto> obras = service.findByTituloContains(titulo);
        return ResponseEntity.ok(obras);
    }

    @GetMapping("/searchByCantidadPaginas/{cantidadPaginas}")
    public ResponseEntity<?> searchByCantidadPaginas(@PathVariable Integer cantidadPaginas) {
        List<ObraDto> obras = service.findByCantidadPaginasGreaterThan(cantidadPaginas);
        return ResponseEntity.ok(obras);
    }

    @GetMapping("/searchByYearPublicacionBefore/{yearPublicacion}")
    public ResponseEntity<?> searchByYearPublicacionBefore(@PathVariable Integer yearPublicacion) {
        List<ObraDto> obras = service.findByYearPublicacionBefore(yearPublicacion);
        return ResponseEntity.ok(obras);
    }

    @GetMapping("/searchByYearPublicacionAfter/{yearPublicacion}")
    public ResponseEntity<?> searchByYearPublicacionAfter(@PathVariable Integer yearPublicacion) {
        List<ObraDto> obras = service.findByYearPublicacionAfter(yearPublicacion);
        return ResponseEntity.ok(obras);
    }

    @GetMapping("/searchByEditorial/{editorial}")
    public ResponseEntity<?> searchByEditorial(@PathVariable String editorial) {
        List<ObraDto> obras = service.findByEditorial(editorial);
        return ResponseEntity.ok(obras);
    }

}
