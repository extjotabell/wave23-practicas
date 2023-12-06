package org.mercadolibre.Dakar.entity;

public class Car extends Vehicle {

    public Car(Integer velocity, Integer acceleration, Integer turningAngle, String patent, Double weight, Integer wheels) {
        super(velocity, acceleration, turningAngle, patent, weight, wheels);
    }

    @Override
    public double calculateRaceScore() {
        return this.getVelocity() * 0.5 * this.getAcceleration() / (this.getTurningAngle() * (1000.0 - 4 * 100));
    }
}
