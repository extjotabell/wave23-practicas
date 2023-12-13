package com.ospina.linkTracker.excepcion;

public class LinkNoEncontradoExcepcion extends RuntimeException{

        private static final long serialVersionUID = 1L;

        private static final String MENSAJE = "El link no fue encontrado.";

        public LinkNoEncontradoExcepcion() {
            super(MENSAJE);
        }

}
