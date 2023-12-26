package com.ospina.blogyoutuber.modelo.entidad;

import com.ospina.blogyoutuber.util.ValidadorArgumento;

import java.time.LocalDate;

public class EntradaBlog {
    private static int id = 0;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;

    public EntradaBlog(String titulo, String autor, LocalDate fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        id++;
    }

    public static EntradaBlog reconstruir(String titulo, String autor, LocalDate fechaPublicacion){
        ValidadorArgumento.validarObligatorio(titulo, "El título es requerido.");
        ValidadorArgumento.validarObligatorio(autor, "El autor es requerido.");
        ValidadorArgumento.validarObligatorio(fechaPublicacion, "La fecha de publicación es requerida.");
        return new EntradaBlog(titulo, autor, fechaPublicacion);
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
