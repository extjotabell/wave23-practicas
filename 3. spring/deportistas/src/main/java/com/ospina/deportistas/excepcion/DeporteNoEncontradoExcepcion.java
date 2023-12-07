package com.ospina.deportistas.excepcion;

public class DeporteNoEncontradoExcepcion extends Exception{

            private static final long serialVersionUID = 1L;
            private static final String MENSAJE = "El deporte no fue encontrado.";
            public DeporteNoEncontradoExcepcion() {
                super(MENSAJE);
            }
}
