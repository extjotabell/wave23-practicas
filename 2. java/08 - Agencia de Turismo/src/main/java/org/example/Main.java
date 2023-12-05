package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Agencia agencia = new Agencia();

        Cliente cliente = new Cliente("Ailen", "Pereira", "38855748");

        List<TipoDeReserva> paqueteCompleto = new ArrayList<>();
        paqueteCompleto.add(TipoDeReserva.PAQUETE_COMPLETO);

        List<TipoDeReserva> reserva2 = new ArrayList<>(Arrays.asList(TipoDeReserva.BOLETO_VIAJE,TipoDeReserva.BOLETO_VIAJE,TipoDeReserva.COMIDA));

        Localizador localizador1 = new Localizador(cliente, paqueteCompleto);
        Localizador localizador2 = new Localizador(cliente, reserva2);

        agencia.generarLocalizador(localizador1);
        agencia.generarLocalizador(localizador2);

        aplicarDescuentos(localizador1,agencia,cliente);
        aplicarDescuentos(localizador2, agencia, cliente);

        System.out.println("\nEstadisticas:");
        Repositorio repo = agencia.getRepositorio();
        System.out.println("Cantidad total de reservas: " + repo.cantidadTotalDeReservas());
        System.out.println("Cantidad de localizadores vendidos: " + repo.getCantidadDeLocalizadoresVendidos());
        System.out.println("Valor total ventas genereadas: " + repo.getTotalVentas());
        System.out.println("Promedio de ventas generadas: " + repo.getPromedioVentas());
        System.out.println(repo.getReservasPorTipo());
    }

    private static void aplicarDescuentos(Localizador l, Agencia a, Cliente c) {
        System.out.println("\nTotal reserva sin descuentos: " + l.getTotal());

        double descuentoLocalizador = l.verificarDescuento();
        System.out.println("\nDescuento por Paquete Completo o Boletos viajes: $" + descuentoLocalizador);
        double total = l.getTotal();
        double descuentoAgencia = total * a.aplicarDescuento(c);
        System.out.println("Descuento de agencia: $" + descuentoAgencia);


        double totalGeneral = total - descuentoAgencia - descuentoLocalizador;
        System.out.println("\nTotal con descuentos: $" + totalGeneral);
        l.setTotal(totalGeneral);
    }


}