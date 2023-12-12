package org.ejercicio.dealership.exception;

public class InvalidDatesException extends Exception {
    public InvalidDatesException() {
        super("Formato de fechas inválido.");
    }
}
