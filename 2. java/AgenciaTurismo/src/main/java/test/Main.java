package test;

import org.bootcamp.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Cliente cliente = new Cliente("Lucas Salerno");
        List<Reserva> reservas = List.of(
                new Reserva(Tipo.HOTEL, 100),
                new Reserva(Tipo.BOLETO, 100),
                new Reserva(Tipo.TRANSPORTE, 100),
                new Reserva(Tipo.COMIDA, 100)
        );
        Localizador localizador = new Localizador(cliente, reservas);
        localizador.print(); // (100+100+100+100)*0.9 = 360

        // Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, almacenar e imprimir el resultado.
        // (Descuento por 2 reservas de hotel o boletos)
        List<Reserva> reserva_2 = List.of(
                new Reserva(Tipo.HOTEL, 100),
                new Reserva(Tipo.HOTEL, 100),
                new Reserva(Tipo.BOLETO, 200),
                new Reserva(Tipo.BOLETO, 200)
        );
        Localizador localizador_2 = new Localizador(cliente, reserva_2);
        localizador_2.print(); // (100+100)*0.95 + (200+200)*0.95 = 570

        // Crear un localizador con una sola reserva para el mismo cliente.
        // (Descuento por más de 2 localizadores previos)
        List<Reserva> reserva_3 = List.of(
                new Reserva(Tipo.HOTEL, 100)
        );
        Localizador localizador_3 = new Localizador(cliente, reserva_3);
        localizador_3.print(); // 100*0.95 = 95

        // Uno que no tenga descuento
        Cliente cliente_2 = new Cliente("María Perez");
        List<Reserva> reserva_4 = List.of(
                new Reserva(Tipo.HOTEL, 100),
                new Reserva(Tipo.BOLETO, 100)
        );
        Localizador localizador_4 = new Localizador(cliente_2, reserva_4);
        localizador_4.print(); // 100+100 = 200

        // Cantidad de localizadores vendidos
        System.out.println("Cantidad de localizadores vendidos: " + Localizador.getCantidadLocalizadores());

        // Cantidad total de reservas
        System.out.println("Cantidad total de reservas: " + Reserva.getCantidadReservas());

        // Diccionario de reservas clasificados por tipo
        System.out.println("\nDiccionario de reservas clasificados por tipo:");
        Reserva.getMapReservas().forEach((tipo, reserva) -> {
            System.out.println("- " + tipo.getTipo() + ": " + reserva);
        });

        // Total ventas
        System.out.println("\nTotal ventas: $" + Localizador.getTotalVentas());

        // Promedio de ventas
        System.out.println("Promedio de ventas: $" + Localizador.getPromedioVentas());
    }

}
