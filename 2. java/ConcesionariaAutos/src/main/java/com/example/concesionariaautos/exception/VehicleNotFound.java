package com.example.concesionariaautos.exception;

public class VehicleNotFound extends RuntimeException{
    public VehicleNotFound(int id){
        super("El vehiculo de id " + id + " no existe");
    }
}
