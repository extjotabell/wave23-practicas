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


        //System.out.println(localizador1.getCliente().getNombre() + ". Total del localizador1: " + total);
        System.out.println("Total reserva sin descuentos: " + localizador2.getTotal());
        System.out.println("Descuentos: \n");

        double descuentoLocalizador = localizador2.verificarDescuento();
        System.out.println("Descuento por Paquete Completo o Boletos viajes: $" + descuentoLocalizador);
        double total = localizador2.getTotal();
        double descuentoAgencia = total * agencia.aplicarDescuento(cliente);
        System.out.println("Descuento de agencia: $" + descuentoAgencia);


        double totalGeneral = total - descuentoAgencia - descuentoLocalizador;
        System.out.println("Total con descuentos: " + totalGeneral);
    }


}