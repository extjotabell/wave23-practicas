package org.example;

import org.example.cliente.Cliente;
import org.example.localizador.Localizador;
import org.example.repositorio.Repositorio;
import org.example.reserva.Reserva;
import org.example.reserva.TipoReserva;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Repositorio repo = new Repositorio();

        Cliente cliente1 = new Cliente("Nicolas", "Reinaldo");

        repo.agregarCliente(cliente1)
        ;
        Reserva reserva1 = new Reserva(TipoReserva.TRANSPORTE, 150.00, "Transporte reserva");
        Reserva reserva2 = new Reserva(TipoReserva.BOLETO_VIAJE, 2000.00, "Boleto reserva");
        Reserva reserva3 = new Reserva(TipoReserva.COMIDA, 90.00, "Comida reserva");
        Reserva reserva4 = new Reserva(TipoReserva.HOTEL, 1500.00, "Hotel reserva");

        List<Reserva> reservas = new ArrayList<>();
        reservas.add(reserva1);
        reservas.add(reserva2);
        reservas.add(reserva3);
        reservas.add(reserva4);

        Localizador paqueteCompleto = new Localizador(cliente1, reservas);

        cliente1.agregarLocalizador(paqueteCompleto);

        System.out.println(paqueteCompleto);

        Reserva hotel1 = new Reserva(TipoReserva.HOTEL, 1500.00, "Hotel reserva");
        Reserva hotel2 = new Reserva(TipoReserva.HOTEL, 2000.00, "Hotel reserva");
        Reserva boleto1 = new Reserva(TipoReserva.BOLETO_VIAJE, 2000.00, "Boleto reserva");
        Reserva boleto2 = new Reserva(TipoReserva.BOLETO_VIAJE, 2000.00, "Boleto reserva");

        List<Reserva> reservas2 = new ArrayList<>();
        reservas2.add(hotel1);
        reservas2.add(hotel2);
        reservas2.add(boleto1);
        reservas2.add(boleto2);

        Localizador paqueteHotelBoleto = new Localizador(cliente1, reservas2);

        cliente1.agregarLocalizador(paqueteHotelBoleto);

        System.out.println(paqueteHotelBoleto);

        List<Reserva> reservas3 = new ArrayList<>();
        reservas3.add(hotel1);

        Localizador hotel =new Localizador(cliente1,reservas3);

        System.out.println(hotel);

        List<Reserva> reservas4 = new ArrayList<>();
        reservas4.add(hotel2);

        Localizador localizadorHotel =new Localizador(cliente1,reservas4);

        System.out.println(localizadorHotel);


    }
}