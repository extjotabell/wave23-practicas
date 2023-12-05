package org.example;

public class Main {
    public static void main(String[] args) {
        Carrera carrera1 = new Carrera(5000, 1000, "Dakar", 5);

        carrera1.altaAuto(150, 30, 30, "SCA0000");
        carrera1.altaAuto(130, 30, 30, "SCA0000");
        carrera1.altaAuto(180, 40, 40, "SCA0002");
        carrera1.altaAuto(600, 80, 100, "SCA0006");

        carrera1.altaMoto(120, 10, 50, "SCA0003");
        carrera1.altaMoto(190, 15, 40, "SCA0004");
        carrera1.altaMoto(150, 15, 30, "SCA0005");

        // Ganador
        carrera1.definirGanador();

        // Socorrer
        carrera1.socorrerMoto("SCA0000");
        carrera1.socorrerAuto("SCA0006");

        // Eliminar
        carrera1.eliminarVehiculoConPatente("SCA0006");
        carrera1.getVehiculos().stream().forEach(System.out::println);
    }
}