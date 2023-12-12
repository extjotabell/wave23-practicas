package org.ejercicio.dealership.exception;

public class InvalidPricesException extends Exception {
    public InvalidPricesException() {
        super("Formato de precios inválido.");
    }
}
