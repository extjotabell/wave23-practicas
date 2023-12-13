package com.blog.blog.dto;

import com.blog.blog.entity.EntradaBlog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntradaBlogDTO {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;

    public EntradaBlogDTO(EntradaBlog entradaBlog) {
        this.id = entradaBlog.getId();
        this.titulo = entradaBlog.getTitulo();
        this.nombreAutor = entradaBlog.getNombreAutor();
        Date input = entradaBlog.getFechaPublicacion();
        this.fechaPublicacion = LocalDate.ofInstant(input.toInstant(), ZoneId.systemDefault()).toString();
    }
}
