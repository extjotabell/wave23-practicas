package com.ospina.blogyoutuber.excepcion;

public class EntradaBlogNoEncontradaExcepcion extends RuntimeException{
    public EntradaBlogNoEncontradaExcepcion(String mensaje) {
        super(mensaje);
    }
}
