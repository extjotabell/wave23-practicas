package org.mercadolibre.Dakar;

import org.mercadolibre.Dakar.entity.Car;
import org.mercadolibre.Dakar.entity.Motorcycle;
import org.mercadolibre.Dakar.entity.Vehicle;
import org.mercadolibre.Dakar.model.CarLifeGuard;
import org.mercadolibre.Dakar.model.MotorcycleLifeGuard;
import org.mercadolibre.Dakar.model.Race;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Race race = createRace();

        addVehiclesToRace(race);

        printVehiclesInRace(race);

        printRaceWinner(race);

        helpCarAndMotorcycle(race);

        deleteAndPrintVehiclesAfterDelete(race);
    }

    private static Race createRace() {
        return new Race(1000.0, 5000.0, "Carrera Principal", 5, new ArrayList<>(), new MotorcycleLifeGuard(), new CarLifeGuard());
    }

    private static void addVehiclesToRace(Race race) {
        race.addToRaceMotorcycle(120, 80, 45, "MOTO 1");
        race.addToRaceMotorcycle(110, 90, 30, "MOTO 2");
        race.addToRaceCar(180, 120, 20, "AUTO 1");
        race.addToRaceCar(160, 110, 25, "AUTO 2");
    }

    private static void printVehiclesInRace(Race race) {
        System.out.println("Vehículos en la carrera:");
        race.getVehicles().forEach(Main::printVehicle);
    }

    private static void printRaceWinner(Race race) {
        Vehicle winner = race.findWinner();
        System.out.println("Ganador de la carrera: " + winner.getClass().getSimpleName() + " Patent: " + winner.getPatent());
    }

    private static void helpCarAndMotorcycle(Race race) {
        CarLifeGuard carLifeGuard = race.getCarLifeGuard();
        carLifeGuard.help(new Car(160, 110, 25, "AUTO 2", 1000.0, 4));

        MotorcycleLifeGuard motorcycleLifeGuard = race.getMotorcycleLifeGuard();
        motorcycleLifeGuard.help(new Motorcycle(110, 90, 30, "MOTO 2", 300.0, 2));
    }

    private static void deleteAndPrintVehiclesAfterDelete(Race race) {
        race.deleteVehicleByPatent("MOTO 2");

        System.out.println("Vehículos después de eliminar uno:");
        race.getVehicles().forEach(Main::printVehicle);
    }

    private static void printVehicle(Vehicle vehicle) {
        System.out.println(" - " + vehicle.getClass().getSimpleName() + " Patent: " + vehicle.getPatent());
    }
}