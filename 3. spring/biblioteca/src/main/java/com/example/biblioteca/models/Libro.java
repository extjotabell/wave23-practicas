package com.example.biblioteca.models;

public class Libro {
    private static int nextId;
    private int id;
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor) {
        this.id = ++ nextId;
        this.titulo = titulo;
        this.autor = autor;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Libro.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
