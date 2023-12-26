package com.example.youtuber.entity;

public class EntradaBlog {
    private int id;
    private String titulo;
    private String autor;
    private String fecha;

    public EntradaBlog(int id, String titulo, String autor, String fecha) {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
