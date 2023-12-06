package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalizadorImple localizadorImple = new LocalizadorImple();

        Cliente cliente = new Cliente("Martin", "Lackington");
        Reserva reserva = new Reserva(1,"Vuelo",1000);
        Reserva reserva1 = new Reserva(1,"Hotel",1000);
        Reserva reserva2 = new Reserva(1,"Comida",800);
        Reserva reserva3 = new Reserva(1,"Transporte",700);

        List<Reserva> listaReservas = new ArrayList<>();
        listaReservas.add(reserva);
        listaReservas.add(reserva1);
        listaReservas.add(reserva2);
        listaReservas.add(reserva3);

        Localizador localizador = new Localizador(cliente,listaReservas);

        localizadorImple.addLista(localizador);

        localizador.calcularMonto();
        System.out.println(localizadorImple);
    }
}