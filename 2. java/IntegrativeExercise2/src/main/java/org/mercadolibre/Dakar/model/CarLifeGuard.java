package org.mercadolibre.Dakar.model;

import org.mercadolibre.Dakar.entity.Car;
import org.mercadolibre.Dakar.entity.ILifeGuard;
import org.mercadolibre.Dakar.entity.Vehicle;

public class CarLifeGuard implements ILifeGuard {
    @Override
    public void help(Vehicle vehicle) {
        if (vehicle instanceof Car car) {
            System.out.println("Socorriendo auto " + car.getPatent());
        } else {
            System.out.println("No se puede socorrer. El vehículo no es un auto.");
        }
    }
}
