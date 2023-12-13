package com.example.youtuber.exception;

public class BlogAlreadyExistException extends RuntimeException {
    public BlogAlreadyExistException() {
        super("Ya existe una entrada con el ID proporcionado.");
    }
}
