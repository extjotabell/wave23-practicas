package org.example;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<TipoDeReserva> reservas;
    private double total;

    public Localizador(Cliente cliente, List<TipoDeReserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = getTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<TipoDeReserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<TipoDeReserva> reservas) {
        this.reservas = reservas;
    }

    public double getTotal() {
        return reservas.stream()
                .mapToDouble(tipoDeReserva -> tipoDeReserva.getCosto())
                .sum();
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double verificarDescuento(){
        double descuentos = 0.0;
        long totalBoletosDeViaje = getReservas().stream()
                .filter(tipoDeReserva -> tipoDeReserva.equals(TipoDeReserva.BOLETO_VIAJE))
                .count();

        long totalReservasHotel = getReservas().stream()
                .filter(tipoDeReserva -> tipoDeReserva.equals(TipoDeReserva.RESERVA_HOTEL))
                .count();

        long paqueteCompleto = getReservas().stream()
                .filter(tipoDeReserva -> tipoDeReserva.equals(TipoDeReserva.PAQUETE_COMPLETO))
                .count();

        if( paqueteCompleto> 0){
            descuentos += total * 0.1;
        }else if(totalBoletosDeViaje >= 2 || totalReservasHotel >=2){
            descuentos += total * 0.05;
        }

        return descuentos;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", reservas=" + reservas +
                ", total=" + total +
                '}';
    }
}
