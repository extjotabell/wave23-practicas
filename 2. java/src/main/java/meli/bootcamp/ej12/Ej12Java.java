package meli.bootcamp.ej12;

import java.util.ArrayList;
import java.util.List;

import meli.bootcamp.ej12.cliente.Cliente;
import meli.bootcamp.ej12.localizador.Localizador;
import meli.bootcamp.ej12.repositorio.RepositorioLocalizador;
import meli.bootcamp.ej12.reserva.Reserva;
import meli.bootcamp.ej12.reserva.TipoReserva;

/**
 * Ejercicio 12: Agencia de turismo
 */
public class Ej12Java {
  public static void main(String[] args) {
    Cliente yo = new Cliente("1234", "Tiago Ramirez");

    List<Reserva> paquete1 = new ArrayList<Reserva>();
    Reserva r1 = new Reserva("Hotel Lindo de cancun", 100.0, TipoReserva.HOTEL);
    Reserva r2 = new Reserva("Viaje ida cancun", 100.0, TipoReserva.BOLETO_VIAJE);
    Reserva r3 = new Reserva("Tacos", 100.0, TipoReserva.COMIDA);
    Reserva r4 = new Reserva("Ferrari :D", 100.0, TipoReserva.TRANSPORTE);
    paquete1.add(r1);
    paquete1.add(r2);
    paquete1.add(r3);
    paquete1.add(r4);

    System.out.println("------------------Paquete 1------------------");
    Localizador l1 = new Localizador(yo, paquete1);
    System.out.println(l1);
    RepositorioLocalizador.agregarLocalizador(l1);

    List<Reserva> paquete2 = new ArrayList<Reserva>();
    Reserva r5 = new Reserva("Hotel Holandes", 100.0, TipoReserva.HOTEL);
    Reserva r6 = new Reserva("Hotel Irlandes", 100.0, TipoReserva.HOTEL);
    Reserva r7 = new Reserva("Vuelo Holanda ida", 100.0, TipoReserva.BOLETO_VIAJE);
    Reserva r8 = new Reserva("Vuelo Irlanda ida", 100.0, TipoReserva.BOLETO_VIAJE);
    paquete2.add(r5);
    paquete2.add(r6);
    paquete2.add(r7);
    paquete2.add(r8);

    System.out.println("------------------Paquete 2------------------");
    Localizador l2 = new Localizador(yo, paquete2);
    System.out.println(l2);
    RepositorioLocalizador.agregarLocalizador(l2);

    List<Reserva> paquete3 = new ArrayList<Reserva>();
    Reserva r9 = new Reserva("Recorrido Buenos Aires", 1000.0, TipoReserva.TRANSPORTE);
    paquete3.add(r9);

    System.out.println("------------------Paquete 2------------------");
    Localizador l3 = new Localizador(yo, paquete3);
    System.out.println(l3);
    RepositorioLocalizador.agregarLocalizador(l3);
  }
}