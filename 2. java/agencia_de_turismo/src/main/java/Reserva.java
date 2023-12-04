import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Reserva {
    private static List<Reserva> reservas = new ArrayList<>();

    private TipoReserva tipo;
    private double valor;

    public Reserva(TipoReserva tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;

        reservas.add(this);
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public void setTipo(TipoReserva tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public static List<Reserva> getReservas() {
        return reservas;
    }

    public static int getCantidadReservas() {
        return reservas.size();
    }

    // Obtener un diccionario de todas las reservas clasificados por tipo (hotel, boleto,comida,transporte).
    public static Map<TipoReserva, List<Reserva>> getDiccionarioReservas() {
        return reservas.stream().collect(Collectors.groupingBy(Reserva::getTipo));
    }

    @Override
    public String toString() {
        return "$" + valor;
    }
}