package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

public class VehicleUtils {
    public static boolean isValidVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            return false;
        }
        if (vehicle.getBrand() == null || vehicle.getBrand().isEmpty()) {
            return false;
        }
        if (vehicle.getModel() == null || vehicle.getModel().isEmpty()) {
            return false;
        }
        if (vehicle.getRegistration() == null || vehicle.getRegistration().isEmpty()) {
            return false;
        }
        if (vehicle.getColor() == null || vehicle.getColor().isEmpty()) {
            return false;
        }
        if (vehicle.getYear() <= 0) {
            return false;
        }
        if (vehicle.getMax_speed() == null || vehicle.getMax_speed().isEmpty()) {
            return false;
        }
        if (vehicle.getFuel_type() == null || vehicle.getFuel_type().isEmpty()) {
            return false;
        }
        if (vehicle.getTransmission() == null || vehicle.getTransmission().isEmpty()) {
            return false;
        }
        if (vehicle.getHeight() <= 0) {
            return false;
        }
        if (vehicle.getWidth() <= 0) {
            return false;
        }
        return !(vehicle.getWeight() <= 0);
    }
}
