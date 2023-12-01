package meli.bootcamp.ej9.garage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Garage {
  List<Vehiculo> vehiculos;

  public Garage() {
    this.vehiculos = new ArrayList<Vehiculo>();
  }

  public void agregarVehiculo(Vehiculo vehiculo) {
    vehiculos.add(vehiculo);
  }

  public List<Vehiculo> vehiculosOrdenadosPorPrecio() {
    return vehiculos.stream()
        .sorted(Comparator.comparing(Vehiculo::getCosto))
        .toList();
  }

  public List<Vehiculo> vehiculosOrdenadosPorMarcaYPrecio() {
    return vehiculos.stream()
        .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Comparator.comparing(Vehiculo::getCosto)))
        .toList();
  }

  public List<Vehiculo> vehiculosConPrecioMenorA(double precioMax) {
    return vehiculos.stream()
        .filter(vehiculo -> vehiculo.getCosto() < precioMax)
        .toList();
  }

  public List<Vehiculo> vehiculosConPrecioMayorOIgualA(double precioMin) {
    return vehiculos.stream()
        .filter(vehiculo -> vehiculo.getCosto() > precioMin)
        .toList();
  }

  public double precioPromedio() {
    OptionalDouble resultado = vehiculos.stream()
        .mapToDouble(v -> v.getCosto()).average();
    if (resultado.isPresent()) {
      return resultado.getAsDouble();
    }
    return 0.0;
  }
}
