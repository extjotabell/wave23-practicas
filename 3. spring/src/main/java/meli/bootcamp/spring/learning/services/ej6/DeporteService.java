package meli.bootcamp.spring.learning.services.ej6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import meli.bootcamp.spring.learning.entities.ej6.Deporte;

@Service
public class DeporteService {
  private List<Deporte> deportes;

  public DeporteService() {
    this.deportes = new ArrayList<Deporte>();
    this.deportes.add(new Deporte("Futbol", 2));
    this.deportes.add(new Deporte("Rugby", 4));
    this.deportes.add(new Deporte("MMA", 5));
    this.deportes.add(new Deporte("Padel", -1));
  }

  public List<Deporte> getAll() {
    return this.deportes;
  }

  public Optional<Deporte> getByName(String name) {
    return this.deportes.stream().filter(d -> d.getNombre().equals(name)).findFirst();
  }

}
