package com.Rest.edadPersona.excepcion;

public class FechaNacimientoInvalidaException extends Exception{

        private static final long serialVersionUID = 1L;
        private static final String MENSAJE = "La fecha de nacimiento es invalida.";
        public FechaNacimientoInvalidaException() {
            super(MENSAJE);
        }
}
