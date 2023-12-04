package org.example;

import java.util.*;

public class Agencia {
    private Repositorio repositorio;
    private Map<Cliente, List<Localizador>> historialVentas;

    public Agencia() {
        this.repositorio = new Repositorio();
        this.historialVentas = new HashMap<>();
    }

    public void generarLocalizador(Localizador localizador){
        this.repositorio.agregarLocalizador(localizador);
        actualizarHistorial(localizador.getCliente(), localizador);
    }

    private void actualizarHistorial(Cliente cliente, Localizador localizador){
        if(historialVentas.containsKey(cliente)){
            historialVentas.get(cliente).add(localizador);
        }else{
            historialVentas.put(cliente, new ArrayList<>(Arrays.asList(localizador)));
        }
    }

    public double aplicarDescuento(Cliente cliente){
        double descuento = 0.0;
        if(historialVentas.get(cliente) != null){
            if(historialVentas.get(cliente).size() % 2 == 0){
                descuento = 0.05;
            };
        }
        return descuento;
    }
}
