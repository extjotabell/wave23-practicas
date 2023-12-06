package org.example;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    double total = 0;

    List<String> stringsBuscados = List.of("Vuelo", "Comida","Hotel","Transporte");


    public void calcularMonto(){
        for (Reserva aux:this.reservas
             ) {
            this.total = this.total + aux.getMonto();
        }
         if (contarObjetosConString(this.reservas,this.stringsBuscados)>=4) {
            this.total = this.total - (this.total*0.1);
        } else if (contarObjetosConString(this.reservas,this.stringsBuscados)>2) {
            this.total = this.total - (this.total*0.05);
        }
    }
    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", reservas=" + reservas +
                ", total=" + total +
                '}';
    }

    public static double contarObjetosConString(List<Reserva> lista, List<String> stringBuscado) {
        int contador = 0;
        for (Reserva objeto : lista) {
            if (stringBuscado.contains(objeto.getTipo())) {
                contador++;
            }
        }
        return contador;
    }
}
