package com.meli.elasticsearchobras.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraDTO {
    private String id;
    private String nombre;
    private String autor;
    private String paginas;
    private String editorial;
    private String anioPublicacion;
}
