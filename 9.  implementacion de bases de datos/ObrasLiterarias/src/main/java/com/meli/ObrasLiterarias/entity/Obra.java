package com.meli.ObrasLiterarias.entity;

import com.meli.ObrasLiterarias.dto.ObraDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity @Document(indexName = "obras")
public class Obra {

    @Id
    private String id;

    private String titulo;
    private String autor;
    private String cantidadPaginas;
    private String editorial;
    private Long yearPublicacion;

    public Obra(ObraDto obraDto) {
        this.titulo = obraDto.getTitulo();
        this.autor = obraDto.getAutor();
        this.cantidadPaginas = obraDto.getCantidadPaginas();
        this.editorial = obraDto.getEditorial();
        this.yearPublicacion = obraDto.getYearPublicacion();
    }
}
