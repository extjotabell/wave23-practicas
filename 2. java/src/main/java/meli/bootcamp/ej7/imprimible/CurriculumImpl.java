package meli.bootcamp.ej7.imprimible;

import meli.bootcamp.ej7.persona.Persona;

public class CurriculumImpl implements IImprimible {

  private Persona persona;

  public CurriculumImpl(Persona persona) {
    this.persona = persona;
  }

  @Override
  public void imprimir() {
    System.out.println(persona.toString());
  }

}
