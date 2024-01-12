package com.ospina.hql.controlador.episodio;

import com.ospina.hql.modelo.dto.EpisodeDto;
import com.ospina.hql.servicio.episodio.EpisodioServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/episodio")
public class EpisodioControlador {

    private final EpisodioServicio episodioServicio;

    public EpisodioControlador(EpisodioServicio episodioServicio) {
        this.episodioServicio = episodioServicio;
    }

    @GetMapping("/episodios-por-actor")
    public ResponseEntity<List<EpisodeDto>> encontrarEpisodiosPorActor(@RequestParam("nombre_actor") String nombreActor) {
        return ResponseEntity.ok(episodioServicio.encontrarEpisodiosPorActor(nombreActor));
    }
}
