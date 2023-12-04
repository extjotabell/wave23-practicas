import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.
        // (Descuento por paquete completo)
        Cliente cliente1 = new Cliente("Fulanito de Tal");
        List<Reserva> reservas1 = List.of(
            new Reserva(TipoReserva.HOTEL, 100),
            new Reserva(TipoReserva.BOLETO, 100),
            new Reserva(TipoReserva.TRANSPORTE, 100),
            new Reserva(TipoReserva.COMIDA, 100)
        );
        Localizador localizador1 = new Localizador(cliente1, reservas1);
        localizador1.print(); // (100+100+100+100)*0.9 = 360

        // Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, almacenar e imprimir el resultado.
        // (Descuento por 2 reservas de hotel o boletos)
        List<Reserva> reserva2 = List.of(
            new Reserva(TipoReserva.HOTEL, 100),
            new Reserva(TipoReserva.HOTEL, 100),
            new Reserva(TipoReserva.BOLETO, 200),
            new Reserva(TipoReserva.BOLETO, 200)
        );
        Localizador localizador2 = new Localizador(cliente1, reserva2);
        localizador2.print(); // (100+100)*0.95 + (200+200)*0.95 = 570

        // Crear un localizador con una sola reserva para el mismo cliente.
        // (Descuento por más de 2 localizadores previos)
        List<Reserva> reserva3 = List.of(
            new Reserva(TipoReserva.HOTEL, 100)
        );
        Localizador localizador3 = new Localizador(cliente1, reserva3);
        localizador3.print(); // 100*0.95 = 95

        // Uno que no tenga descuento
        Cliente cliente2 = new Cliente("Menganito de Tal");
        List<Reserva> reserva4 = List.of(
            new Reserva(TipoReserva.HOTEL, 100),
            new Reserva(TipoReserva.BOLETO, 100)
        );
        Localizador localizador4 = new Localizador(cliente2, reserva4);
        localizador4.print(); // 100+100 = 200

        // Cantidad de localizadores vendidos
        System.out.println("Cantidad de localizadores vendidos: " + Localizador.getCantidadLocalizadores());

        // Cantidad total de reservas
        System.out.println("Cantidad total de reservas: " + Reserva.getCantidadReservas());

        // Diccionario de reservas clasificados por tipo
        System.out.println("\nDiccionario de reservas clasificados por tipo:");
        Reserva.getDiccionarioReservas().forEach((tipo, reservas) -> {
            System.out.println("- " + tipo.getTipo() + ": " + reservas);
        });

        // Total ventas
        System.out.println("\nTotal ventas: $" + Localizador.getTotalVentas());

        // Promedio de ventas
        System.out.println("Promedio de ventas: $" + Localizador.getPromedioVentas());
    }
}
