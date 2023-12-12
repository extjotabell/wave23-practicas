package org.ejercicio.dealership.exception;

public class NotFindVehicleByRegistrationException extends Exception {
    public NotFindVehicleByRegistrationException() {
        super("No se encontó el vehículo con esa patente.");
    }
}
