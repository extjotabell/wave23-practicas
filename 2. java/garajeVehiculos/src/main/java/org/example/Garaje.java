package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Garaje {

    private static Integer id = 0;
    private List<Vehiculo> vehiculos;

    public Garaje(List<Vehiculo> vehiculos) {
        Garaje.id++;
        this.vehiculos = vehiculos;
    }

    public void ordenarVehiculosPorPrecio() {
        this.vehiculos.stream()
                .sorted((x, y) -> x.getCosto().compareTo(y.getCosto()))
                .forEach(System.out::println);

    }

    public void ordenarVehiculosPorMarcaYPrecio() {
        this.vehiculos.stream()
                .sorted((x, y) -> {
                    Integer comparacionMarca = x.getMarca().compareTo(y.getMarca());
                    return (comparacionMarca == 0) ? x.getCosto().compareTo(y.getCosto()) : comparacionMarca;
                })
                .forEach(System.out::println);
    }

    public void traerVehiculosConPrecioMenorA(Integer limite) {
        this.vehiculos.stream()
                .filter(x -> x.getCosto() < limite)
                .forEach(System.out::println);
    }

    public void traerVehiculosConPrecioMayoroIgualA(Integer limite) {
        this.vehiculos.stream()
                .filter(x -> x.getCosto() >= limite)
                .forEach(System.out::println);
    }

    public void traerPromedioTotalDePrecios() {
        double promedio = this.vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);

        System.out.println(promedio);
    }

    /*
    public void traerPromedioTotalDePrecios() {
        Double calculo = this.vehiculos.stream()
                .mapToDouble(x -> {
                            Integer suma = 0;
                            suma += x.getCosto();
                            return (double) suma / this.vehiculos.size();
                        }
                )
                .sum();
        System.out.println(calculo);
    }
     */
}
