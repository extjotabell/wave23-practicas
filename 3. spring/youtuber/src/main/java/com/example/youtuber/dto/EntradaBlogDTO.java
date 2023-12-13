package com.example.youtuber.dto;

import com.example.youtuber.entity.EntradaBlog;

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
}
