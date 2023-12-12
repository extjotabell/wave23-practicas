package com.meli.autos.exception.custom;

public class VehicleException extends RuntimeException{
    public static final String VEHICLE_ID_EXCEPTION = "The vehicle with the given ID does not exist.";

    public VehicleException(String message){
        super(message);
    }

}
