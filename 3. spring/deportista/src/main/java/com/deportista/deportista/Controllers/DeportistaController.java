package com.deportista.deportista.Controllers;

import com.deportista.deportista.DTOS.Request.NameSportRequestDTO;
import com.deportista.deportista.DTOS.Response.DeporteResponseDTO;
import com.deportista.deportista.DTOS.Response.ListaDeporteResponseDTO;
import com.deportista.deportista.DTOS.Response.ListaPersonasDeportistasResponseDTO;
import com.deportista.deportista.Services.QueriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deportista")
public class DeportistaController {

    @Autowired
    private QueriesService queriesService;
    @GetMapping("/findSports")
    public ResponseEntity<ListaDeporteResponseDTO> retornaDeportes() {
        return ResponseEntity.ok().body(queriesService.getListaDeportes());
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeporteResponseDTO> retornaNivelDeporte(@PathVariable NameSportRequestDTO name) {
        return queriesService.conseguirDeportePorNombre(name)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<ListaPersonasDeportistasResponseDTO> retornaPersonasDeportistas(){
        return ResponseEntity.ok().body(queriesService.conseguirPersonasDeportistas());
    }

}
