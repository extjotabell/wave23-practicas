package com.ospina.hql.controlador.pelicula;

import com.ospina.hql.modelo.dto.PeliculaDto;
import com.ospina.hql.servicio.pelicula.PeliculaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/pelicula")
public class PeliculaControlador {

    private final PeliculaServicio peliculaServicio;

    public PeliculaControlador(PeliculaServicio peliculaServicio) {
        this.peliculaServicio = peliculaServicio;
    }

    @GetMapping("/peliculas-por-rating-actores")
    public ResponseEntity<List<PeliculaDto>> encontrarPeliculasPorRatingActores(@RequestParam("rating") BigDecimal rating) {
        return ResponseEntity.ok(peliculaServicio.encontrarPeliculasPorRatingActores(rating));
    }

    @GetMapping("/peliculas-por-genero")
    public ResponseEntity<List<PeliculaDto>> encontrarPeliculasPorGenero(@RequestParam("genreId") Integer genreId) {
        return ResponseEntity.ok(peliculaServicio.encontrarPeliculasPorGenero(genreId));
    }
}
