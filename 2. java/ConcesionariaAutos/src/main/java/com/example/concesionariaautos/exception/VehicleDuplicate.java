package com.example.concesionariaautos.exception;

public class VehicleDuplicate extends RuntimeException {
    public VehicleDuplicate(int id) {
        super("Ya existe un vehiculo con el id " + id);
    }
}
