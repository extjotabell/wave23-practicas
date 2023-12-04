package meli.bootcamp.ej12.repositorio;

import java.util.ArrayList;
import java.util.List;

import meli.bootcamp.ej12.localizador.Localizador;

public class RepositorioLocalizador {
  private static List<Localizador> localizadores = new ArrayList<Localizador>();

  public static List<Localizador> localizadoresPorClienteId(String idCliente) {
    return localizadores.stream().filter(l -> l.getCliente().getId().equals(idCliente)).toList();
  }

  public static void agregarLocalizador(Localizador localizador) {
    localizadores.add(localizador);
  }
}
