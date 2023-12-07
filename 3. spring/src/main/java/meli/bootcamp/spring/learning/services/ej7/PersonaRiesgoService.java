package meli.bootcamp.spring.learning.services.ej7;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meli.bootcamp.spring.learning.dto.ej7.PersonaDto;
import meli.bootcamp.spring.learning.entities.ej7.Persona;
import meli.bootcamp.spring.learning.entities.ej7.Sintoma;

@Service
public class PersonaRiesgoService {
  @Autowired
  private SintomaService sintomaService;
  private List<Persona> personas;

  public PersonaRiesgoService(SintomaService sintomaService) {
    this.sintomaService = sintomaService;
    this.personas = new ArrayList<Persona>();
    this.datosSemilla();
  }

  public List<PersonaDto> obtenerPersonasRiesgo() {
    List<Persona> personasDeRiesgo = this.personas.stream().filter(p -> p.getEdad() > 60 && p.getSintomas().size() >= 1)
        .toList();

    List<PersonaDto> personaRiesgoDtos = new ArrayList<PersonaDto>();
    personasDeRiesgo.forEach(p -> personaRiesgoDtos.add(new PersonaDto(p.getNombre(), p.getApellido())));
    return personaRiesgoDtos;
  }

  private void datosSemilla() {
    List<Sintoma> sintomas = this.sintomaService.obtenerTodos();
    Sintoma fiebre = sintomas.get(0);
    Sintoma dolorPulmon = sintomas.get(1);
    Sintoma faltaOxigeno = sintomas.get(2);

    Persona p1 = new Persona("123", "Tiago", "Ramirez", 22);
    p1.agregarSintoma(fiebre);
    this.personas.add(p1);

    Persona p2 = new Persona("543", "Alguien", "Mayor", 82);
    p2.agregarSintoma(dolorPulmon);
    p2.agregarSintoma(faltaOxigeno);
    this.personas.add(p2);
  }
}
