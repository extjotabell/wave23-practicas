package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Localizador {
    private Cliente cliente;
    private double precioTotal = 0;
    private ArrayList<Reserva> reservas;

    public Localizador(Cliente cliente, ArrayList<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.precioTotal = this.calcularPrecio();
    }

    private double calcularPrecio(){
        int cantBoletosAvion = reservas.stream().filter(reserva -> reserva.getTipo().equals(TipoProducto.BOLETO_AVION)).toList().size();
        int cantBoletosHotel = reservas.stream().filter(reserva -> reserva.getTipo().equals(TipoProducto.HOTEL)).toList().size();
        int cantComida = reservas.stream().filter(reserva -> reserva.getTipo().equals(TipoProducto.COMIDA)).toList().size();
        int cantTraslado = reservas.stream().filter(reserva -> reserva.getTipo().equals(TipoProducto.TRASLADOS)).toList().size();

        double precio = reservas.stream().map(Reserva::getPrecio).mapToDouble(Double::doubleValue).sum();

        if(Agencia.cantidadLocalizadoresCompradosAnteriormentePorCliente(this.cliente.getDni()) >= 2) {
            System.out.println("Se aplica descuento del 5% por haber adquirido almenos 2 localizadores anteriormente");
            precio *= 0.95;
        }

        if(cantBoletosAvion > 0 && cantBoletosHotel > 0 && cantComida > 0 && cantTraslado > 0) {
            System.out.println("Se aplica descuento del 10% por adquirir paquete completo");
            precio *= 0.90;
        }

        if(cantBoletosAvion >= 2 || cantBoletosHotel >= 2) {
            System.out.println("Se aplica descuento del 5% por 2 reservas de hotel o 2 boletos de avión");
            precio *= 0.95;
        }

        return precio;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Localizador: " +
                cliente +
                "\tReservas: " + reservas +
                "\tPrecioTotal: " + precioTotal + "\n";
    }
}
