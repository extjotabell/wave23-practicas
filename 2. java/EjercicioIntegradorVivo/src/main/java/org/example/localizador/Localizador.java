package org.example.localizador;

import org.example.cliente.Cliente;
import org.example.reserva.Reserva;
import org.example.reserva.TipoReserva;

import java.util.List;


public class Localizador {

    private Cliente cliente;
    private Double total = 0.00;
    private Boolean disponible = true;
    private List<Reserva> paquete;

    public Localizador(Cliente cliente, List<Reserva> paquete) {
        this.cliente = cliente;
        this.paquete = paquete;

        paquete.forEach(p -> this.total += p.getPrecio());

        if(this.cliente.tieneDosLocalizadores()){
            this.total = this.total - (this.total * 0.05);
        }else if(tieneTodos()){
            this.total = this.total - (this.total * 0.10);
        }else if(tieneDosBoletosViaje() || tieneDosHoteles()){
            this.total = this.total - (this.total * 0.05);
        }
    }

    private Boolean tieneComida(){
        return paquete.stream().anyMatch(p -> p.getTipo() == TipoReserva.COMIDA);
    }

    private Boolean tieneBoletoViaje(){
        return paquete.stream().anyMatch(p -> p.getTipo() == TipoReserva.BOLETO_VIAJE);
    }

    private Boolean tieneHotel(){
        return paquete.stream().anyMatch(p -> p.getTipo() == TipoReserva.HOTEL);
    }

    private Boolean tieneTransporte(){
        return paquete.stream().anyMatch(p -> p.getTipo() == TipoReserva.TRANSPORTE);
    }

    private Boolean tieneTodos(){
        return tieneComida() && tieneHotel() && tieneTransporte() && tieneBoletoViaje();
    }

    private Boolean tieneDosHoteles(){
        return paquete.stream().filter(p -> p.getTipo() == TipoReserva.HOTEL).count() == 2;
    }

    private Boolean tieneDosBoletosViaje(){
        return paquete.stream().filter(p -> p.getTipo() == TipoReserva.BOLETO_VIAJE).count() == 2;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Localizador{ \n" +
                "Cliente= \n" + cliente +
                "\nTotal=" + total +
                "\nPaquete=" + paquete +
               " \n}";
    }
}
