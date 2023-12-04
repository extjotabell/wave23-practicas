import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private static List<Localizador> localizadores = new ArrayList<>();

    private Cliente cliente;
    private List<Reserva> reservas;
    private double valorTotal;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.valorTotal = calcularValorTotal();

        localizadores.add(this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
        this.valorTotal = calcularValorTotal();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public static List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public static double getTotalVentas() {
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

    public int getCantidadLocalizadores(Cliente cliente) {
        return (int) localizadores.stream()
            .filter(localizador -> localizador.getCliente().equals(cliente))
            .count();
    }

    public boolean isPaqueteCompleto() {
        // Lista de reservas tiene uno de cada tipo como minimo
        return reservas.stream()
            .map(Reserva::getTipo)
            .distinct()
            .count() == TipoReserva.values().length;
    }

    public boolean hasDescuentoReserva() {
        return reservas.stream()
            .map(Reserva::getTipo)
            .filter(tipo -> tipo == TipoReserva.HOTEL)
            .count() >= 2;
    }

    public boolean hasDescuentoBoleto() {
        return reservas.stream()
            .map(Reserva::getTipo)
            .filter(tipo -> tipo == TipoReserva.BOLETO)
            .count() >= 2;
    }

    public double calcularValorSinDescuento() {
        return reservas.stream()
            .mapToDouble(Reserva::getValor)
            .sum();
    }

    public double calcularValorTotal() {
        // Descuentos sobre el valor de cada reserva
        double valor = reservas.stream()
            .mapToDouble(reserva -> {
                // 2 o más reservas de hotel o boletos -> 5% de descuento en ellas
                if (reserva.getTipo() == TipoReserva.HOTEL) {
                    if (hasDescuentoReserva()) { return reserva.getValor() * 0.95; }
                } else if (reserva.getTipo() == TipoReserva.BOLETO) {
                    if (hasDescuentoBoleto()) { return reserva.getValor() * 0.95; }
                }

                return reserva.getValor();
            })
            .sum();

        // Descuentos sobre el total de la compra
        // Más de 2 localizadores previos -> 5% de descuento
        if (getCantidadLocalizadores(getCliente()) >= 2) {
            valor *= 0.95;
        }

        // Si es paquete completo -> 10% de descuento
        if (isPaqueteCompleto()) {
            valor *= 0.9;
        }

        return valor;
    }

    public void print() {
        double valorSinDescuento = calcularValorSinDescuento();
        double valorConDescuento = getValorTotal();

        System.out.println("--------------------");

        System.out.println("Cliente: " + getCliente());

        getReservas().forEach(reserva -> {
            System.out.println(
                "- " + reserva.getTipo().getTipo()
                + ": $" + reserva.getValor()
            );
        });

        if (valorSinDescuento == valorConDescuento) {
            System.out.println("No hay descuento");
            System.out.println("Valor total: $" + getValorTotal());
        } else {
            System.out.println("Valor sin descuento: $" + calcularValorSinDescuento());
            System.out.println("Valor con descuento: $" + getValorTotal());
        }

        System.out.println("--------------------\n");
    }
}
