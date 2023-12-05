package meli.bootcamp.ej13.guardaropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import meli.bootcamp.ej13.prenda.Prenda;

public class GuardaRopa {

  private static int numero = 0;

  Map<Integer, List<Prenda>> prendasGuardadas;

  public GuardaRopa() {
    this.prendasGuardadas = new HashMap<>();
  }

  public Integer guardarPrendas(List<Prenda> listaDePrenda) {
    this.prendasGuardadas.put(++numero, listaDePrenda);
    return numero;
  }

  public void mostrarPrendas() {
    prendasGuardadas.forEach((integer, prendas) -> System.out.println("Numero: " + integer + "Prendas: " + prendas));
  }

  public List<Prenda> devolverPrendas(Integer numero) {
    return prendasGuardadas.remove(numero);
  }
}
