package com.meli.ObrasLiterarias.dto;

import com.meli.ObrasLiterarias.entity.Obra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraDto implements Serializable {
    String id;
    String titulo;
    String autor;
    String cantidadPaginas;
    String editorial;
    Long yearPublicacion;

    public ObraDto(String titulo, String autor, String cantidadPaginas, String editorial, Long yearPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.editorial = editorial;
        this.yearPublicacion = yearPublicacion;
    }

    public ObraDto(Obra obra) {
        this.id = obra.getId();
        this.titulo = obra.getTitulo();
        this.autor = obra.getAutor();
        this.cantidadPaginas = obra.getCantidadPaginas();
        this.editorial = obra.getEditorial();
        this.yearPublicacion = obra.getYearPublicacion();
    }
}