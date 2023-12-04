package bootcamp;

import java.util.List;
import java.util.Map;

public class Localizador implements ICalculoCosto {

    private PaqueteTuristico paquete;

    private Cliente cliente;

    private double total;

    public Localizador(Cliente cliente, PaqueteTuristico paquete) {
        this.total = 0.0;
        this.cliente = cliente;
        this.paquete = paquete;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "paquete=" + paquete +
                ", cliente=" + cliente +
                ", total=" + total +
                '}';
    }

    public boolean paqueteCompleto(){
        return paquete.paqueteCompleto();
    }

    public boolean dosBoletosODosReservas(){
        return  paquete.dosBoletosODosReservas();
    }

    public double getTotal() {
        return total;
    }

    @Override
    public double calcularCosto(Map<Descuentos.TIPOS_DESCUENTOS, Boolean> descuentosMap) {
        if (total == 0.0) total = paquete.calcularCosto(descuentosMap);
        return total;
    }
}
