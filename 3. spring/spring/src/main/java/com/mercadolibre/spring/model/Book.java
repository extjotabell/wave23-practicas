package com.mercadolibre.spring.model;

public class Book {

    private String title;
    private String description;
    private String content;
    private String author;

    public Book() {
    }
    public Book(String title, String description, String content, String autor) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.author = autor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
