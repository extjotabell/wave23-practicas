package com.ospina.blogyoutuber.excepcion;

public class EntradaBlogExistenteExcepcion extends RuntimeException{
    public EntradaBlogExistenteExcepcion(String mensaje) {
        super(mensaje);
    }
}
