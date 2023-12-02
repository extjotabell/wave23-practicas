package org.mercadolibre.ejercicios.ejercicio2.model;

public class Reports extends Document {
    private String text;
    private int numberOfPages;
    private String author;
    private Person reviewer;

    public Reports(int id, String texto, int cantidadPaginas, String autor, Person revisor) {
        super(id);
        this.text = texto;
        this.numberOfPages = cantidadPaginas;
        this.author = autor;
        this.reviewer = revisor;
    }

    @Override
    public void print() {
        System.out.println("Imprimiendo informe");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Person getReviewer() {
        return reviewer;
    }

    public void setReviewer(Person reviewer) {
        this.reviewer = reviewer;
    }
}
