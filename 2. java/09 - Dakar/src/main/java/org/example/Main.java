package org.example;

public class Main {
    public static void main(String[] args) {
        Carrera dakar = new Carrera(5000, 1000, "Dakar", 5);

        dakar.altaAuto(150, 30, 30, "SCA0000");
        dakar.altaAuto(130, 30, 30, "SCA0000");
        dakar.altaAuto(180, 40, 40, "SCA0002");
        dakar.altaAuto(600, 80, 100, "SCA0006");

        dakar.altaMoto(120, 10, 50, "SCA0003");
        dakar.altaMoto(190, 15, 40, "SCA0004");
        dakar.altaMoto(150, 15, 30, "SCA0005");

        // Ganador
        dakar.definirGanador();

        // Socorrer
        dakar.socorrerMoto("SCA0000");
        dakar.socorrerAuto("SCA0006");

        // Eliminar
        dakar.eliminarVehiculoConPatente("SCA0006");
        dakar.eliminarVehiculo(dakar.getVehiculos().get(3));
        dakar.getVehiculos().stream().forEach(vehiculo -> System.out.println(vehiculo.getPatente()));
    }
}