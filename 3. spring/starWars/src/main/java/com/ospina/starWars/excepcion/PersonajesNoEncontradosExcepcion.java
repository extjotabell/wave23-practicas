package com.ospina.starWars.excepcion;

public class PersonajesNoEncontradosExcepcion extends Exception{
        private static final long serialVersionUID = 1L;
        private static final String MENSAJE = "Los personajes no fueron encontrados.";
        public PersonajesNoEncontradosExcepcion() {
            super(MENSAJE);
        }
}
