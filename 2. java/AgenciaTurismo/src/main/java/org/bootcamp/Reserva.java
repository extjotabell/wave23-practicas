package org.bootcamp;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Reserva {

    protected static List<Reserva> reservas = new ArrayList<>();

    protected Tipo tipo;
    protected double valor;

    public Reserva(Tipo tipo, double valor){
        this.tipo = tipo;
        this.valor = valor;

        reservas.add(this);
    }

    public static List<Reserva> getReservas() {
        return reservas;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "tipo=" + tipo +
                ", valor=" + valor +
                '}';
    }

    public static int getCantidadReservas(){
        return  reservas.size();
    }

    public static Map<Tipo, List<Reserva>> getMapReservas(){
        return reservas.stream()
                .collect(Collectors.groupingBy(Reserva::getTipo));
    }

}
