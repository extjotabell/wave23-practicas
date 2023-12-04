package main;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // LOS ESCENARIOS ESTAN COMENTADOS
        /// DESCOMENTAR EL QUE DESEES PROBAR :)


        // Creo una lista de localizadores
        List<Localizador> localizadores = new ArrayList<>();

        // Creo un repositorio
        Repositorio repo = new Repositorio();

        // Creo todos los tipos de reservas
        Reserva hotel = new Reserva("Hotel", 5);
        Reserva comida = new Reserva("Comida", 1);
        Reserva boleto = new Reserva("Boleto de viaje", 3);
        Reserva transporte = new Reserva("Transporte", 2);

        // -------------------------------- ESCENARIO 1 -------------------------------- //
        /*Cliente c1 = new Cliente("Marcos", "Costanzo", "40955907");
        List<Reserva> reservasC1 = new ArrayList<>(Arrays.asList(hotel, comida, boleto, transporte));
        Localizador l1 = new Localizador(c1, reservasC1);

        // Agrego el localizador al repositorio
        repo.setLocalizadores(l1);

        // Imprimimos
        System.out.println("Total sin descuentos: " + l1.getTotalReservasSinDesc());
        System.out.println("Total de descuentos: " + l1.getTotalDescuentos());
        System.out.println("Total con descuentos: " + (l1.getTotalReservasSinDesc() - l1.getTotalDescuentos()));*/
        // ------------------------------ FIN ESCENARIO 1 ------------------------------ //

        // -------------------------------- ESCENARIO 2 -------------------------------- //
        /*Cliente c1 = new Cliente("Marcos", "Costanzo", "40955907");
        List<Reserva> reservasC1 = new ArrayList<>(Arrays.asList(hotel, hotel, boleto, boleto));
        Localizador l1 = new Localizador(c1, reservasC1);

        // Agrego el localizador al repositorio
        repo.setLocalizadores(l1);

        // Imprimimos
        System.out.println("Total sin descuentos: " + l1.getTotalReservasSinDesc());
        System.out.println("Total de descuentos: " + l1.getTotalDescuentos());
        System.out.println("Total con descuentos: " + (l1.getTotalReservasSinDesc() - l1.getTotalDescuentos()));*/
        // ------------------------------ FIN ESCENARIO 2 ------------------------------ //

        // -------------------------------- ESCENARIO 3 -------------------------------- //
        Cliente c1 = new Cliente("Marcos", "Costanzo", "40955907");
        List<Reserva> reservasC1 = new ArrayList<>(Arrays.asList(hotel));
        Localizador l1 = new Localizador(c1, reservasC1);

        // Agrego el localizador al repositorio
        repo.setLocalizadores(l1);

        // Imprimimos
        System.out.println("Total sin descuentos: " + l1.getTotalReservasSinDesc());
        System.out.println("Total de descuentos: " + l1.getTotalDescuentos());
        System.out.println("Total con descuentos: " + (l1.getTotalReservasSinDesc() - l1.getTotalDescuentos()));
        // ------------------------------ FIN ESCENARIO 3 ------------------------------ //

    }
}
