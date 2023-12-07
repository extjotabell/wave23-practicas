package com.deportista.deportista.Services;


import com.deportista.deportista.DTOS.Request.NameSportRequestDTO;
import com.deportista.deportista.DTOS.Response.DeporteResponseDTO;
import com.deportista.deportista.DTOS.Response.ListaDeporteResponseDTO;
import com.deportista.deportista.DTOS.Response.ListaPersonasDeportistasResponseDTO;
import com.deportista.deportista.DTOS.Response.PersonaDeportistaResponseDTO;
import com.deportista.deportista.Entities.DeporteEntity;

import java.util.Optional;

public final class QueriesService {

    private QueriesService() {}
    public static ListaDeporteResponseDTO getListaDeportes() {
        return new ListaDeporteResponseDTO(BaseDeDatosService.DEPORTE_ENTITIES);
    }

    public static Optional<DeporteResponseDTO> conseguirDeportePorNombre(NameSportRequestDTO nameSportDTO) {
        return BaseDeDatosService.DEPORTE_ENTITIES.stream().filter(DeporteEntity -> DeporteEntity.getNombre().
                equals(nameSportDTO.getNombre())).map(d -> new DeporteResponseDTO(d.getNivel())).findFirst();
    }

    public static ListaPersonasDeportistasResponseDTO conseguirPersonasDeportistas() {
        return new ListaPersonasDeportistasResponseDTO(BaseDeDatosService.joinPersonaDeporte.entrySet().stream()
                .filter(e -> !e.getValue().isEmpty())
                .map(e ->
                        new PersonaDeportistaResponseDTO(e.getKey().getNombre(), e.getKey().getApellido(), e.getValue())
                )
                .toList());
    }

}
