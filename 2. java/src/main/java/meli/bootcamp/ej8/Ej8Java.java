package meli.bootcamp.ej8;

import meli.bootcamp.ej8.animal.Animal;
import meli.bootcamp.ej8.animal.Gato;
import meli.bootcamp.ej8.animal.Perro;
import meli.bootcamp.ej8.animal.Vaca;

/**
 * Ejercicio 8: Clases Abstractas e Interfaces - Practica Integradora - Ej 3/3
 */
public class Ej8Java {
  public static void main(String[] args) {
    Animal perro = new Perro();
    perro.emitirSonido();
    perro.comer();
    perro.emitirSonido();
    
    Animal gato = new Gato();
    gato.emitirSonido();
    gato.comer();
    gato.emitirSonido();
    
    Animal vaca = new Vaca();
    vaca.emitirSonido();
    vaca.comer();
    vaca.emitirSonido();
  }
}
