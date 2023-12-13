package com.example.youtuber.exception;

public class BlogDoesNotExistException extends RuntimeException {
    public BlogDoesNotExistException() {
        super("No existe una entrada de blog con el ID proporcionado,");
    }
}
