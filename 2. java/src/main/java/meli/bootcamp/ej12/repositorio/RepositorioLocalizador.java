package meli.bootcamp.ej12.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import meli.bootcamp.ej12.localizador.Localizador;
import meli.bootcamp.ej12.reserva.Reserva;
import meli.bootcamp.ej12.reserva.TipoReserva;

public class RepositorioLocalizador {
  private static List<Localizador> localizadores = new ArrayList<Localizador>();

  public static List<Localizador> localizadoresPorClienteId(String idCliente) {
    return localizadores.stream().filter(l -> l.getCliente().getId().equals(idCliente)).toList();
  }

  public static void agregarLocalizador(Localizador localizador) {
    localizadores.add(localizador);
  }

  public static Integer cantidadLocalizadoresVendidos() {
    return localizadores.size();
  }

  public static Integer cantidadTotalReservas() {
    return localizadores.stream().mapToInt(l -> l.getPaquete().size()).sum();
  }

  public static Map<TipoReserva, List<Reserva>> diccionarioClasificacion() {
    Map<TipoReserva, List<Reserva>> resultado = new HashMap<TipoReserva, List<Reserva>>();
    List<Reserva> reservasHotel = new ArrayList<>();
    List<Reserva> reservasComida = new ArrayList<>();
    List<Reserva> reservasBoletoViaje = new ArrayList<>();
    List<Reserva> reservasTransporte = new ArrayList<>();

    localizadores.forEach(l -> {
      reservasHotel.addAll(l.reservasHoteles());
      reservasComida.addAll(l.reservasComidas());
      reservasBoletoViaje.addAll(l.reservasBoletosViaje());
      reservasTransporte.addAll(l.reservasTransportes());
    });

    resultado.put(TipoReserva.HOTEL, reservasHotel);
    resultado.put(TipoReserva.COMIDA, reservasComida);
    resultado.put(TipoReserva.BOLETO_VIAJE, reservasBoletoViaje);
    resultado.put(TipoReserva.TRANSPORTE, reservasTransporte);

    return resultado;
  }

  public static Double totalVentas() {
    return localizadores.stream().mapToDouble(l -> l.getTotal()).sum();
  }

  public static Double promedioVentas() {
    return totalVentas() / localizadores.size();
  }
}
