package org.mercadolibre.Dakar.model;

import org.mercadolibre.Dakar.entity.ILifeGuard;
import org.mercadolibre.Dakar.entity.Motorcycle;
import org.mercadolibre.Dakar.entity.Vehicle;

public class MotorcycleLifeGuard implements ILifeGuard {
    @Override
    public void help(Vehicle vehicle) {
        if (vehicle instanceof Motorcycle motorcycle) {
            System.out.println("Socorriendo moto " + motorcycle.getPatent());
        } else {
            System.out.println("No se puede socorrer. El vehículo no es una moto.");
        }
    }
}
