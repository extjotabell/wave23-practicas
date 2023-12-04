package bootcamp;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(13, "Fer", "Meza", 212);
        Localizador localizador1 = new Localizador(cliente1, new PaqueteTuristico(1000, 500, 3, 500, new ArrayList<>()));
        RepositorioCliente repositorioCliente = new RepositorioCliente(cliente1);
        repositorioCliente.realizarCompraLocalizador(localizador1);
        Localizador localizador2 = new Localizador(cliente1, new PaqueteTuristico(1000, 200, 2, 500, new ArrayList<Reserva>(List.of(new Reserva(500), new Reserva(700)))));
        repositorioCliente.realizarCompraLocalizador(localizador2);
        Localizador localizador3 = new Localizador(cliente1, new PaqueteTuristico(100, 500, 3, 500, new Reserva(500)));
        repositorioCliente.realizarCompraLocalizador(localizador3);

    }
}