package com.meli.ejercicioBlog.dtos.response;

import com.meli.ejercicioBlog.dtos.request.EntradaBlogCreacionRequestDTO;
import com.meli.ejercicioBlog.model.EntradaBlog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter @AllArgsConstructor
public class EntradaBlogResponseDTO {
    private String id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;

    public static EntradaBlogResponseDTO entityToDto(EntradaBlog entity){
        return new EntradaBlogResponseDTO(
                entity.getId(),
                entity.getTitulo(),
                entity.getNombreAutor(),
                entity.getFechaPublicacion()
        );
    }
}
