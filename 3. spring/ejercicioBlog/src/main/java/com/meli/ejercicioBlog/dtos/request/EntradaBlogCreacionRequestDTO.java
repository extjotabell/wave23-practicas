package com.meli.ejercicioBlog.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.ejercicioBlog.model.EntradaBlog;
import lombok.Getter;

@Getter
public class EntradaBlogCreacionRequestDTO {
    @JsonProperty("id")
    private String id;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("nombre_autor")
    private String nombreAutor;
    @JsonProperty("fecha_publicacion")
    private String fechaPublicacion;

    public static EntradaBlog DtoToEntity(EntradaBlogCreacionRequestDTO dto){
        return new EntradaBlog(
                dto.id,
                dto.titulo,
                dto.nombreAutor,
                dto.fechaPublicacion
        );
    }
}
