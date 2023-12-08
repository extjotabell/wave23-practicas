package org.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Localizador {

    protected static List<Localizador> localizadores = new ArrayList<>();

    protected Cliente cliente;
    protected List<Reserva> reservas;
    protected double valorTotal;

    public Localizador(Cliente cliente, List<Reserva> reservas){
        this.cliente = cliente;
        this.reservas = reservas;
        this.valorTotal = calcularValorTotal();

        localizadores.add(this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
        this.valorTotal = calcularValorTotal();
    }

    public static List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public static double getTotalVentas(){
        return localizadores.stream()
                .mapToDouble(Localizador::getValorTotal)
                .sum();
    }

    public static double getPromedioVentas() {
        return getTotalVentas() / localizadores.size();
    }

    public static int getCantidadLocalizadores() {
        return localizadores.size();
    }

    public int getCantidadLocalizadores(Cliente cliente){
        return (int) localizadores.stream()
                .filter(localizador -> localizador.getCliente().equals(cliente))
                .count();
    }

    public boolean isPaqueteCompleto(){
        return reservas.stream()
                .map(Reserva::getTipo)
                .distinct()
                .count() == Tipo.values().length;
    }

    public boolean hasDescuentoReserva(){
        return reservas.stream()
                .map(Reserva::getTipo)
                .filter(tipo -> tipo == Tipo.HOTEL)
                .count() >= 2;
    }

    public boolean hasDescuentoBoleto(){
        return reservas.stream()
                .map(Reserva::getTipo)
                .filter(tipo -> tipo == Tipo.BOLETO)
                .count() >= 2;
    }

    public double calcularValorSinDescuento(){
        return reservas.stream()
                .mapToDouble(Reserva::getValor)
                .sum();
    }

    public double calcularValorTotal(){
        double valor = reservas.stream()
                .mapToDouble(reserva -> {
                    if (reserva.getTipo() == Tipo.HOTEL){
                        if(hasDescuentoReserva()){
                            return reserva.getValor() * 0.95;
                        }
                        else if (reserva.getTipo() == Tipo.BOLETO) {
                            if (hasDescuentoBoleto()){
                                return reserva.getValor() * 0.95;
                            }
                        }
                    }
                    return reserva.getValor();
                })
                .sum();

        if(getCantidadLocalizadores(this.getCliente()) >= 2){
            valor *= 0.95;
        }

        if (isPaqueteCompleto()){
            valor *= 0.9;
        }

        return valor;
    }

    public void print(){
        double valorSinDescuento = calcularValorSinDescuento();
        double valorConDescuento = getValorTotal();
        System.out.println("Cliente: " + this.getCliente());

        this.getReservas().forEach(reserva -> {
            System.out.println("- " + reserva.getTipo().getTipo() + ": $" + reserva.getValor());
        });

        if (valorSinDescuento == valorConDescuento){
            System.out.println("No hay descuentos aplicados.");
            System.out.println("Valor Total: " + getValorTotal());
        }
        else {
            System.out.println("Valor sin descuento: " + calcularValorSinDescuento());
            System.out.println("Valor con descuento: " + getValorTotal());
        }
    }

}
