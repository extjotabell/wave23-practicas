package meli.bootcamp.ej12.localizador;

import java.util.List;

import meli.bootcamp.ej12.cliente.Cliente;
import meli.bootcamp.ej12.reserva.Reserva;
import meli.bootcamp.ej12.reserva.TipoReserva;

public class Localizador {
  private Cliente cliente;
  private Double total;
  private List<Reserva> paquete;

  public Localizador(Cliente cliente, List<Reserva> paquete) {
    this.cliente = cliente;
    this.paquete = paquete;
    this.total = 0.0;
    this.calcularPrecioConDescuentos();
  }

  private Boolean tieneTodos() {
    return this.tieneBoletoViaje() && this.tieneComida() && this.tieneHotel() && this.tieneTransporte();
  }

  private Boolean tieneBoletoViaje() {
    return paquete.stream().anyMatch(p -> p.getTipo() == TipoReserva.BOLETO_VIAJE);
  }

  private Boolean tieneComida() {
    return paquete.stream().anyMatch(p -> p.getTipo() == TipoReserva.COMIDA);
  }

  private Boolean tieneHotel() {
    return paquete.stream().anyMatch(p -> p.getTipo() == TipoReserva.HOTEL);
  }

  private Boolean tieneTransporte() {
    return paquete.stream().anyMatch(p -> p.getTipo() == TipoReserva.TRANSPORTE);
  }

  private Boolean tiene2ReservasHotel() {
    return paquete.stream().filter(p -> p.getTipo() == TipoReserva.HOTEL).count() == 2;
  }

  private Boolean tiene2ReservasBoletoViaje() {
    return paquete.stream().filter(p -> p.getTipo() == TipoReserva.BOLETO_VIAJE).count() == 2;
  }

  public Cliente getCliente() {
    return this.cliente;
  }

  private void calcularPrecioConDescuentos() {
    this.paquete.forEach(p -> {
      if (p.getTipo() == TipoReserva.BOLETO_VIAJE && tiene2ReservasBoletoViaje()) {
        total += p.getPrecio(5.0);
      } else if (p.getTipo() == TipoReserva.HOTEL && tiene2ReservasHotel()) {
        total += p.getPrecio(5.0);
      } else {
        total += p.getPrecio();
      }
    });
    if (cliente.tieneAlMenos2Localizadores()) {
      this.total = this.total * 0.95;
    }
    if (this.tieneTodos()) {
      this.total = this.total * 0.9;
    }
  }

  @Override
  public String toString() {
    return "Localizador: [cliente=" + cliente + ", total=" + total + ", paquete=\n\t" + paquete + "\n]";
  }

  public List<Reserva> getPaquete() {
    return this.paquete;
  }

  public List<Reserva> reservasHoteles() {
    return this.paquete.stream().filter(r -> r.getTipo() == TipoReserva.HOTEL).toList();
  }

  public List<Reserva> reservasComidas() {
    return this.paquete.stream().filter(r -> r.getTipo() == TipoReserva.COMIDA).toList();
  }

  public List<Reserva> reservasBoletosViaje() {
    return this.paquete.stream().filter(r -> r.getTipo() == TipoReserva.BOLETO_VIAJE).toList();
  }

  public List<Reserva> reservasTransportes() {
    return this.paquete.stream().filter(r -> r.getTipo() == TipoReserva.TRANSPORTE).toList();
  }

  public Double getTotal() {
    return this.total;
  }
}
