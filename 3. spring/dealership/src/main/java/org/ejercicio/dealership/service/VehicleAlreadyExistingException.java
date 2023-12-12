package org.ejercicio.dealership.service;

public class VehicleAlreadyExistingException extends Exception {
    public VehicleAlreadyExistingException() {
        super("Vehículo ya existente.");
    }
}
