package bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PaqueteTuristico implements ICalculoCosto {
    //Esto se podría modelar con una clase
    private double costoComida;
    private double costoBoleto;
    private int numBoletos;
    private double costoTransporte;

    //Decidi conservar aquí la lista de reservas y solo verificar que el paquete sea completo
    private List<Reserva> reservas;

    public PaqueteTuristico(double costoComida, double costoBoleto, int numBoletos, double costoTransporte, List<Reserva> reservas) {
        this.costoComida = costoComida;
        this.costoBoleto = costoBoleto;
        this.numBoletos = numBoletos;
        this.costoTransporte = costoTransporte;
        this.reservas = reservas;
    }
    public PaqueteTuristico(double costoComida, double costoBoleto, int numBoletos, double costoTranspore, Reserva reserva) {
        this(costoComida, costoBoleto, numBoletos, costoTranspore, new ArrayList<Reserva>(List.of(reserva)));
    }
    public boolean paqueteCompleto() {
        return (numBoletos > 0 && costoComida > 0 && costoTransporte > 0 && !reservas.isEmpty());
    }

    //Supondre que o dos o mas boletos o dos o mas reservas
    public boolean dosBoletosODosReservas() {
        return numBoletos >= 2 || reservas.size() >= 2;
    }

    @Override
    public String toString() {
        return "PaqueteTuristico{" +
                "costoComida=" + costoComida +
                ", costoBoleto=" + costoBoleto +
                ", numBoletos=" + numBoletos +
                ", costoTransporte=" + costoTransporte +
                ", reservas=" + reservas +
                '}';
    }

    @Override
    public double calcularCosto(Map<Descuentos.TIPOS_DESCUENTOS, Boolean> descuentosMap) {
        double costoTotal = costoComida + (costoBoleto * numBoletos) + costoTransporte;

        if (descuentosMap.get(Descuentos.TIPOS_DESCUENTOS.DOS_RESERVAS_O_DOS_BOLETOS)) {
            reservas.forEach(reserva -> {reserva.setCosto(reserva.getCosto() - (reserva.getCosto() * Descuentos.dosReservasODosBoletos) );});
        }
        
        costoTotal = costoTotal + reservas.stream().mapToDouble(Reserva::getCosto).reduce(0, Double::sum);

        if (descuentosMap.get(Descuentos.TIPOS_DESCUENTOS.FUTURAS_COMPRAS)) {
            costoTotal = costoTotal - (costoTotal * Descuentos.futurasCompras);
        }

        if (descuentosMap.get(Descuentos.TIPOS_DESCUENTOS.PAQUETE_COMPLETO)) {
            costoTotal = costoTotal - (costoTotal * Descuentos.paqueteCompleto);
        }

        return costoTotal;
    }
}

