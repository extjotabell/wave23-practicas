package com.ospina.blogYoutuber.excepcion;

public class EntradaBlogExistenteExcepcion extends RuntimeException{
    public EntradaBlogExistenteExcepcion(String mensaje) {
        super(mensaje);
    }
}
