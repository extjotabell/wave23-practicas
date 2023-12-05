package org.example;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("12345678","Maria","Becerra");

        //Primeras reservas
        Reserva reservaHotel1 = new Reserva(1,TipoProducto.HOTEL,2000);
        Reserva reservaAvion1 =  new Reserva(2,TipoProducto.BOLETO_AVION,4000);

        ArrayList<Reserva> primerasReservas = new ArrayList<>();
        primerasReservas.add(reservaHotel1);
        primerasReservas.add(reservaAvion1);

        Localizador localizador1 = new Localizador(cliente,primerasReservas);

        Agencia.realizarCompra(localizador1);

        System.out.println("Valor total de Localizador 1: " + localizador1.getPrecioTotal());

        System.out.println(" ------------------------------------------ ");

        //Segundas reservas
        Reserva reservaHotel21 = new Reserva(3,TipoProducto.HOTEL,2000);
        Reserva reservaAvion2 =  new Reserva(4,TipoProducto.BOLETO_AVION,4000);
        Reserva reservaComida2 = new Reserva(5,TipoProducto.COMIDA,3000);
        Reserva reservaTraslado2 = new Reserva(6, TipoProducto.TRASLADOS, 1000);

        ArrayList<Reserva> segundasReservas = new ArrayList<>();
        segundasReservas.add(reservaHotel21);
        segundasReservas.add(reservaAvion2);
        segundasReservas.add(reservaComida2);
        segundasReservas.add(reservaTraslado2);

        Localizador localizador2 = new Localizador(cliente,segundasReservas);

        Agencia.realizarCompra(localizador2);

        System.out.println("Valor total de Localizador 2: " + localizador2.getPrecioTotal());

        System.out.println(" ------------------------------------------ ");

        //Terceras reservas
        Reserva reservaHotel31 = new Reserva(7,TipoProducto.HOTEL,2000);
        Reserva reservaHotel32 = new Reserva(8,TipoProducto.HOTEL,2000);
        Reserva reservaAvion3 =  new Reserva(9,TipoProducto.BOLETO_AVION,4000);
        Reserva reservaComida3 = new Reserva(10,TipoProducto.COMIDA,3000);
        Reserva reservaTraslado3 = new Reserva(11, TipoProducto.TRASLADOS, 1000);

        ArrayList<Reserva> tercerasReservas = new ArrayList<>();
        tercerasReservas.add(reservaHotel31);
        tercerasReservas.add(reservaHotel32);
        tercerasReservas.add(reservaAvion3);
        tercerasReservas.add(reservaComida3);
        tercerasReservas.add(reservaTraslado3);

        Localizador localizador3 = new Localizador(cliente,tercerasReservas);

        Agencia.realizarCompra(localizador3);

        System.out.println("Valor total de Localizador 3: " + localizador2.getPrecioTotal());

        System.out.println(" ------------------------------------------ ");

        //Cuartas reservas
        Reserva reservaHotel4 = new Reserva(12,TipoProducto.HOTEL,2000);

        ArrayList<Reserva> cuartasReservas = new ArrayList<>();
        cuartasReservas.add(reservaHotel4);

        Localizador localizador4 = new Localizador(cliente,cuartasReservas);

        Agencia.realizarCompra(localizador4);

        System.out.println("Valor total de Localizador 4: " + localizador4.getPrecioTotal());

        System.out.println(" ------------------------------------------ ");

        System.out.println("REPORTE DE VENTAS");
        Agencia.generarInforme();
    }
}