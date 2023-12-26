package com.example.youtuber.dto;

import com.example.youtuber.entity.EntradaBlog;

import java.util.Objects;

public class EntradaBlogDTO {
    private int id;
    private String titulo;
    private String autor;
    private String fecha;

    public EntradaBlogDTO(EntradaBlog entradaBlog) {
        id = entradaBlog.getId();
        titulo = entradaBlog.getTitulo();
        autor = entradaBlog.getAutor();
        fecha = entradaBlog.getFecha();
    }

    public EntradaBlogDTO(int id, String titulo, String autor, String fecha) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntradaBlogDTO that = (EntradaBlogDTO) o;
        return id == that.id && Objects.equals(titulo, that.titulo) && Objects.equals(autor, that.autor) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, autor, fecha);
    }
}
