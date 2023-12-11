package meli.bootcamp.spring.learning.ej7.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import meli.bootcamp.spring.learning.ej7.entity.NivelGravedad;
import meli.bootcamp.spring.learning.ej7.entity.Sintoma;

@Service
public class SintomaService {
  private List<Sintoma> sintomas;

  public SintomaService() {
    this.sintomas = new ArrayList<Sintoma>();
    this.datosSemilla();
  }

  public List<Sintoma> obtenerTodos() {
    return this.sintomas;
  }

  public Optional<Sintoma> obtenerPorNombre(String nombre) {
    return this.sintomas.stream().filter(s -> s.getNombre().equals(nombre)).findFirst();
  }

  private void datosSemilla() {
    this.sintomas.add(new Sintoma("23132", "Fiebre", NivelGravedad.LEVE));
    this.sintomas.add(new Sintoma("12321", "Dolor de pulmon", NivelGravedad.MEDIO));
    this.sintomas.add(new Sintoma("64567", "Falta de oxigeno", NivelGravedad.GRAVE));
  }

}
