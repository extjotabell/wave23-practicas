package org.example;

import org.example.entities.Cliente;
import org.example.entities.Localizador;
import org.example.entities.Reserva;
import org.example.entities.TipoReserva;
import org.example.repository.ImplementacionCliente;
import org.example.repository.ImplementacionLocalizador;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ImplementacionLocalizador il = new ImplementacionLocalizador();
        ImplementacionCliente ic = new ImplementacionCliente();

        System.out.println("//////////////// 1 ////////////////");
        Reserva reserva1 = new Reserva(1, TipoReserva.COMPLETA, 10000);
        ArrayList<Reserva> reservasCliente1 = new ArrayList<>();
        reservasCliente1.add(reserva1);
        Cliente cliente1 = new Cliente(123, "Ana", reservasCliente1);
        double costoTotal = il.calcularTotal(reserva1, cliente1);
        Localizador localizador1 = new Localizador(reservasCliente1, cliente1, costoTotal);
        System.out.println(il.guardar(localizador1));
        System.out.println(ic.guardar(cliente1));

        System.out.println("//////////////// 2 ////////////////");
        Reserva reserva2 = new Reserva(2, TipoReserva.HOTEL, 3000);
        Reserva reserva3 = new Reserva(3, TipoReserva.HOTEL, 3000);
        Reserva reserva4 = new Reserva(4, TipoReserva.BOLETOS, 4500);
        Reserva reserva5 = new Reserva(5, TipoReserva.BOLETOS, 4500);
        cliente1.getReservas().addAll(List.of(reserva2, reserva3, reserva4, reserva5));
        ArrayList<Reserva> reservas2Cliente1 = new ArrayList<>(List.of(reserva2, reserva3, reserva4, reserva5));
        double costoTotal2 = il.calcularTotal(reserva2, cliente1) + il.calcularTotal(reserva3, cliente1) + il.calcularTotal(reserva4, cliente1) + il.calcularTotal(reserva5, cliente1);
        Localizador localizador2 = new Localizador(reservas2Cliente1, cliente1, costoTotal2);
        System.out.println(il.guardar(localizador2));

        System.out.println("//////////////// 3 ////////////////");
        Reserva reserva6 = new Reserva(6, TipoReserva.COMIDA, 1500);
        double costoTotal3 = il.calcularTotal(reserva6, cliente1);
        ArrayList<Reserva> reserva3Cliente1 = new ArrayList<>();
        cliente1.getReservas().add(reserva6);
        reserva3Cliente1.add(reserva6);
        Localizador localizador3 = new Localizador(reserva3Cliente1, cliente1, costoTotal3);
        System.out.println(il.guardar(localizador3));

        System.out.println("//////////////// 4 ////////////////");
        cliente1.getReservas().stream()
            .forEach(reserva -> {
                double costoTotalOriginal = reserva.getCostoReserva();
                double costoTotalConDescuento = il.calcularTotal(reserva, cliente1);
                System.out.println("Cliente: " + cliente1.getNombre());
                System.out.println("Reserva: " + reserva.getTipo());
                System.out.println("Costo total original: " + costoTotalOriginal);
                System.out.println("Costo total con descuento: " + costoTotalConDescuento);
                System.out.println("---------------------------");
            });

        System.out.println("//////////////// Cantidad localizadores vendidos ////////////////");
        System.out.println(il.cantidadRegistros());
    }
}