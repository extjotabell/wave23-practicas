package org.mercadolibre.ejercicios.ejercicio2.model;

public class PDFBooks extends Document {
    private int numberOfPages;
    private String author;
    private String title;
    private String gender;

    public PDFBooks(int id, int numberOfPages, String author, String title, String gender) {
        super(id);
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.title = title;
        this.gender = gender;
    }

    @Override
    public void print() {
        System.out.println("Imprimiendo libro PDF");
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
