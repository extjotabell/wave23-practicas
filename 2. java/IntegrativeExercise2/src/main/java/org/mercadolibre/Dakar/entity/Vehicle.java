package org.mercadolibre.Dakar.entity;

public abstract class Vehicle {
    private Integer velocity;
    private Integer acceleration;
    private Integer turningAngle;
    private String patent;
    private Double weight;
    private Integer wheels;

    public Vehicle() {
    }

    public Vehicle(Integer velocity, Integer acceleration, Integer turningAngle, String patent, Double weight, Integer wheels) {
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.turningAngle = turningAngle;
        this.patent = patent;
        this.weight = weight;
        this.wheels = wheels;
    }
    public abstract double calculateRaceScore();

    public Integer getVelocity() {
        return velocity;
    }

    public void setVelocity(Integer velocity) {
        this.velocity = velocity;
    }

    public Integer getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Integer acceleration) {
        this.acceleration = acceleration;
    }

    public Integer getTurningAngle() {
        return turningAngle;
    }

    public void setTurningAngle(Integer turningAngle) {
        this.turningAngle = turningAngle;
    }

    public String getPatent() {
        return patent;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getWheels() {
        return wheels;
    }

    public void setWheels(Integer wheels) {
        this.wheels = wheels;
    }
}
