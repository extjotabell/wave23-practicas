package com.ospina.showroom.controlador;

import com.ospina.showroom.modelo.dto.request.PrendaRequestDto;
import com.ospina.showroom.modelo.entidad.Prenda;
import com.ospina.showroom.servicio.prenda.PrendaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clothes")
public class PrendaControlador {

    private final PrendaServicio prendaServicio;

    public PrendaControlador(PrendaServicio prendaServicio) {
        this.prendaServicio = prendaServicio;
    }

    @PostMapping
    public ResponseEntity<String> guardarPrenda(@RequestBody PrendaRequestDto prendaRequestDto) {
        Long id = prendaServicio.guardarPrenda(prendaRequestDto);
        return ResponseEntity.ok("Prenda creada exitosamente con el ID: " + id);
    }

    @GetMapping
    public ResponseEntity<List<Prenda>> obtenerPrendas(@RequestParam(value = "name", required = false) String nombre) {
        return ResponseEntity.ok(prendaServicio.obtenerPrendas(nombre));
    }

    @GetMapping("/{code}")
    public ResponseEntity<Prenda> obtenerPrendaPorCodigo(@PathVariable Long code) {
        return ResponseEntity.ok(prendaServicio.obtenerPrendaPorCodigo(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<Prenda> actualizarPrenda(@PathVariable Long code, @RequestBody PrendaRequestDto prendaRequestDto) {
        return ResponseEntity.ok(prendaServicio.actualizarPrenda(code, prendaRequestDto));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> eliminarPrenda(@PathVariable Long code) {
        prendaServicio.eliminarPrenda(code);
        return ResponseEntity.ok("Prenda eliminada exitosamente");
    }

    @GetMapping("size/{size}")
    public ResponseEntity<List<Prenda>> obtenerPrendasPorTalla(@PathVariable String size) {
        return ResponseEntity.ok(prendaServicio.obtenerPrendasPorTalla(size));
    }

}
