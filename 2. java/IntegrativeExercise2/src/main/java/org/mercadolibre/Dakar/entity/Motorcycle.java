package org.mercadolibre.Dakar.entity;

public class Motorcycle extends Vehicle{
    public Motorcycle(Integer velocity, Integer acceleration, Integer turningAngle, String patent, Double weight, Integer wheels) {
        super(velocity, acceleration, turningAngle, patent, weight, wheels);
    }

    @Override
    public double calculateRaceScore() {
        return this.getVelocity() * 0.5 * this.getAcceleration() / (this.getTurningAngle() * (300.0 - 2 * 100));
    }
}
