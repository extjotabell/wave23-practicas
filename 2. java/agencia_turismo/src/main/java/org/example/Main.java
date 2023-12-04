package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cli1 = new Cliente(1, "Nombre", "Apellido");

        List<Reserva> reservasCli1 = List.of(new Reserva(true, true, true, true));
        Localizador loc1 = new Localizador(cli1, 100, reservasCli1);

        RepoCliente repoCliente = new RepoCliente();

        repoCliente.agregarLocalizador(loc1);

        List<Reserva> reservasCli2 = List.of(
                new Reserva(true, true, true, false),
                new Reserva(true, true, true, false));
        Localizador loc2 = new Localizador(cli1, 100, reservasCli2);
        repoCliente.agregarLocalizador(loc2);

        List<Reserva> reservasCli3 = List.of(new Reserva(true, true, false, false));
        Localizador loc3 = new Localizador(cli1,100,reservasCli3);
        repoCliente.agregarLocalizador(loc3);
    }
}