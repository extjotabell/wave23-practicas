package com.itbootcamp.Blog.exception;

public class RecursoNoEncontradoException extends RuntimeException{
    public RecursoNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
