package com.ospina.calculadoraCalorias.excepcion;

public class PlatoNoEncontradoExcepcion extends Exception{

    private static final long serialVersionUID = 1L;

    private static final String MENSAJE = "El plato no fue encontrado.";

    public PlatoNoEncontradoExcepcion() {
        super(MENSAJE);
    }
}
