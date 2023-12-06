package org.mercadolibre.Dakar.model;

import org.mercadolibre.Dakar.entity.Car;
import org.mercadolibre.Dakar.entity.Motorcycle;
import org.mercadolibre.Dakar.entity.Vehicle;
import org.mercadolibre.Dakar.exception.NoVehiclesException;

import java.util.List;

public class Race {
    private Double distance;
    private Double awardInDollars;
    private String name;
    private Integer numberOfVehiclesAllowed;
    private List<Vehicle> vehicles;
    private MotorcycleLifeGuard motorcycleLifeGuard;
    private CarLifeGuard carLifeGuard;

    public Race() {
    }

    public Race(Double distance, Double awardInDollars, String name, Integer numberOfVehiclesAllowed, List<Vehicle> vehicles, MotorcycleLifeGuard motorcycleLifeGuard, CarLifeGuard carLifeGuard) {
        this.distance = distance;
        this.awardInDollars = awardInDollars;
        this.name = name;
        this.numberOfVehiclesAllowed = numberOfVehiclesAllowed;
        this.vehicles = vehicles;
        this.motorcycleLifeGuard = motorcycleLifeGuard;
        this.carLifeGuard = carLifeGuard;
    }

    public void addToRaceCar(Integer velocity,Integer acceleration,Integer turningAngle,String patent){
        if (vehicles.size() < numberOfVehiclesAllowed) {
            Car car = new Car(velocity, acceleration, turningAngle, patent, 1000.0,4);
            vehicles.add(car);
        }
    }

    public void addToRaceMotorcycle(Integer velocity,Integer acceleration,Integer turningAngle,String patent){
        if (vehicles.size() < numberOfVehiclesAllowed) {
            Motorcycle motorcycle = new Motorcycle(velocity, acceleration, turningAngle, patent, 300.0,2);
            vehicles.add(motorcycle);
        }
    }

    public Vehicle findWinner(){
        if(vehicles.isEmpty()){
            throw new NoVehiclesException("No hay vehículos para determinar al ganador");
        }

        Vehicle winner = vehicles.get(0);
        double maxScore = winner.calculateRaceScore();

        for (int i = 1; i < vehicles.size(); i++) {
            double currentScore = vehicles.get(i).calculateRaceScore();
            if (currentScore > maxScore) {
                maxScore = currentScore;
                winner = vehicles.get(i);
            }
        }

        return winner;
    }

    public void helpCar(Car car) {
        System.out.println("Socorriendo auto " + car.getPatent());
    }

    public void deleteVehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
    }

    public void deleteVehicleByPatent(String patent) {
        vehicles.removeIf(vehicle -> vehicle.getPatent().equals(patent));
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getAwardInDollars() {
        return awardInDollars;
    }

    public void setAwardInDollars(Double awardInDollars) {
        this.awardInDollars = awardInDollars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfVehiclesAllowed() {
        return numberOfVehiclesAllowed;
    }

    public void setNumberOfVehiclesAllowed(Integer numberOfVehiclesAllowed) {
        this.numberOfVehiclesAllowed = numberOfVehiclesAllowed;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public MotorcycleLifeGuard getMotorcycleLifeGuard() {
        return motorcycleLifeGuard;
    }

    public void setMotorcycleLifeGuard(MotorcycleLifeGuard motorcycleLifeGuard) {
        this.motorcycleLifeGuard = motorcycleLifeGuard;
    }

    public CarLifeGuard getCarLifeGuard() {
        return carLifeGuard;
    }

    public void setCarLifeGuard(CarLifeGuard carLifeGuard) {
        this.carLifeGuard = carLifeGuard;
    }
}
