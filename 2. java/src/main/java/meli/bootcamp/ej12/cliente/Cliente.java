package meli.bootcamp.ej12.cliente;

import java.util.List;

import meli.bootcamp.ej12.localizador.Localizador;
import meli.bootcamp.ej12.repositorio.RepositorioLocalizador;

public class Cliente {
  private String id;
  private String nombre;

  public Cliente(String id, String nombre) {
    this.id = id;
    this.nombre = nombre;
  }

  public String getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public Boolean tieneAlMenos2Localizadores() {
    List<Localizador> localizadores = RepositorioLocalizador.localizadoresPorClienteId(this.id);
    return localizadores.size() >= 2;
  }

  @Override
  public String toString() {
    return this.id;
  }

}
