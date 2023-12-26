package com.ospina.blogYoutuber.excepcion;

public class EntradaBlogNoEncontradaExcepcion extends RuntimeException{
    public EntradaBlogNoEncontradaExcepcion(String mensaje) {
        super(mensaje);
    }
}
