package com.ospina.hql.controlador.serie;

import com.ospina.hql.modelo.dto.SeriesDto;
import com.ospina.hql.servicio.serie.SerieServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/serie")
public class SerieControlador {

    private final SerieServicio serieServicio;

    public SerieControlador(SerieServicio serieServicio) {
        this.serieServicio = serieServicio;
    }

    @GetMapping("/mas-de-n-temporadas")
    public ResponseEntity<List<SeriesDto>> encontrarSeriesConMasDeNTemporadas(@RequestParam("cantidad_temporadas") int cantidadTemporadas) {
        return ResponseEntity.ok(serieServicio.encontrarSeriesConMasDeNTemporadas(cantidadTemporadas));
    }
}
