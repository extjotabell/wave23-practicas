package com.meli.ejercicioBlog.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter @AllArgsConstructor
public class EntradaBlogListaResponseDTO {
    private List<EntradaBlogResponseDTO> entradas;
}
