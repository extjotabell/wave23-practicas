package com.ospina.obrasliterarias.controlador;

import com.ospina.obrasliterarias.entidad.Obra;
import com.ospina.obrasliterarias.servicio.ObraServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/obra")
public class ObraControlador {

    private final ObraServicio obraServicio;

    public ObraControlador(ObraServicio obraServicio) {
        this.obraServicio = obraServicio;
    }

    @PostMapping("/crear")
    public ResponseEntity<Obra> guardarObra(@RequestBody Obra obra) {
        return ResponseEntity.ok(obraServicio.guardarObra(obra));
    }

    @GetMapping
    public ResponseEntity<Iterable<Obra>> obtenerObras() {
        return ResponseEntity.ok(obraServicio.obtenerObras());
    }

    @GetMapping("/por-autor")
    public ResponseEntity<Iterable<Obra>> obtenerObrasPorAutor(@RequestParam("autor") String autor) {
        return ResponseEntity.ok(obraServicio.obtenerObrasPorAutor(autor));
    }

    @GetMapping("/por-titulo")
    public ResponseEntity<Iterable<Obra>> obtenerObrasPorTitulo(@RequestParam("titulo") String titulo) {
        return ResponseEntity.ok(obraServicio.obtenerObrasPorTitulo(titulo));
    }

    @GetMapping("/mas-de-n-paginas")
    public ResponseEntity<Iterable<Obra>> obtenerObrasMasDeNPaginas(@RequestParam("paginas") int paginas) {
        return ResponseEntity.ok(obraServicio.obtenerObrasMasDeNPaginas(paginas));
    }

    @GetMapping("/publicadas-antes-de")
    public ResponseEntity<Iterable<Obra>> obtenerObrasPublicadasAntesDe(@RequestParam("anio") int anio) {
        return ResponseEntity.ok(obraServicio.obtenerObrasPublicadasAntesDe(anio));
    }

    @GetMapping("/publicadas-despues-de")
    public ResponseEntity<Iterable<Obra>> obtenerObrasPublicadasDespuesDe(@RequestParam("anio") int anio) {
        return ResponseEntity.ok(obraServicio.obtenerObrasPublicadasDespuesDe(anio));
    }

    @GetMapping("/por-editorial")
    public ResponseEntity<Iterable<Obra>> obtenerObrasPorEditorial(@RequestParam("editorial") String editorial) {
        return ResponseEntity.ok(obraServicio.obtenerObrasPorEditorial(editorial));
    }
}
