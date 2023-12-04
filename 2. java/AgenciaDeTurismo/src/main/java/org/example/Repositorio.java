package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Repositorio {
    private List<Localizador> localizadores;
    private Set<Cliente> clientes;

    public Repositorio() {
        this.localizadores = new ArrayList<>();
        this.clientes = new HashSet<>();
    }

    public void agregarLocalizador(Localizador l){
        clientes.add(l.getCliente());
        localizadores.add(l);
    }

    public List<Localizador> buscarLocalizadoresPorCliente(Cliente c){
        return localizadores.stream()
                .filter(localizador -> localizador.getCliente().equals(c))
                .toList();
    }

    public int getCantidadDeLocalizadoresVendidos(){
        return localizadores.size();
    }

    public int cantidadTotalDeReservas(){
        return localizadores.stream()
                .mapToInt(value -> value.getReservas().size())
                .sum();
    }

    public Map<TipoDeReserva, Long> getReservasPorTipo(){
        return localizadores.stream()
                .flatMap(localizador -> localizador.getReservas().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public double getTotalVentas(){
        return localizadores.stream()
                .mapToDouble(Localizador::getTotal)
                .sum();
    }

    public double getPromedioVentas(){
        return localizadores.stream()
                .mapToDouble(Localizador::getTotal)
                .average()
                .orElse(0.0);
    }
}
