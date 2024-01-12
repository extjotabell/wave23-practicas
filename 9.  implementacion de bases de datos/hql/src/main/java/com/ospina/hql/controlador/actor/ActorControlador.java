package com.ospina.hql.controlador.actor;

import com.ospina.hql.modelo.entidad.Actor;
import com.ospina.hql.servicio.Actor.ActorServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/actor")
public class ActorControlador {
    private final ActorServicio actorServicio;

    public ActorControlador(ActorServicio actorServicio) {
        this.actorServicio = actorServicio;
    }

    @GetMapping("/actores-con-pelicula-favorita")
    public ResponseEntity<List<Actor>> encontrarActoresConPeliculaFavorita() {
        return ResponseEntity.ok(actorServicio.encontrarActoresConPeliculaFavorita());
    }

    @GetMapping("/actores-con-rating-superior-a")
    public ResponseEntity<List<Actor>> encontrarActoresConRatingSuperiorA(@RequestParam("rating") BigDecimal rating) {
        return ResponseEntity.ok(actorServicio.encontrarActoresConRatingSuperiorA(rating));
    }

    @GetMapping("/actores-por-pelicula")
    public ResponseEntity<List<Actor>> encontrarActoresPorPelicula(@RequestParam("idPelicula") Integer idPelicula) {
        return ResponseEntity.ok(actorServicio.encontrarActoresPorPelicula(idPelicula));
    }
}
