package com.deportista.deportista.DTOS.Response;

import com.deportista.deportista.Entities.DeporteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ListaDeporteResponseDTO {
    private List<DeporteEntity> deporteEntities;
}
