package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Agencia agencia = new Agencia();

        Cliente cliente = new Cliente("Ailen", "Pereira", "38855748");

        List<TipoDeReserva> paqueteCompleto = new ArrayList<>();
        paqueteCompleto.add(TipoDeReserva.PAQUETE_COMPLETO);

        List<TipoDeReserva> reserva2 = new ArrayList<>(Arrays.asList(TipoDeReserva.BOLETO_VIAJE,TipoDeReserva.BOLETO_VIAJE,TipoDeReserva.COMIDA));
        List<TipoDeReserva> reserva3 = new ArrayList<>(Arrays.asList(TipoDeReserva.BOLETO_VIAJE,TipoDeReserva.BOLETO_VIAJE,TipoDeReserva.BOLETO_VIAJE,TipoDeReserva.BOLETO_VIAJE));


        Localizador localizador1 = new Localizador(cliente, paqueteCompleto);
        Localizador localizador2 = new Localizador(cliente, reserva2);
        Localizador localizador3 = new Localizador(cliente, reserva3);

        agencia.generarLocalizador(localizador1);

        agencia.generarLocalizador(localizador1);
        System.out.println(localizador1);
        System.out.println("Total reserva sin descuentos: " + localizador1.getTotal());
        System.out.println("Descuentos: \n");

        double descuentoLocalizador1 = localizador1.verificarDescuento();
        System.out.println("Descuento por Paquete Completo o Boletos viajes: $" + descuentoLocalizador1);
        double total1 = localizador1.getTotal();
        double descuentoAgencia1 = total1 * agencia.aplicarDescuento(cliente);
        System.out.println("Descuento de agencia: $" + descuentoAgencia1);
        double totalGeneral1 = total1 - descuentoAgencia1 - descuentoLocalizador1;
        System.out.println("Total con descuentos: " + totalGeneral1);
        System.out.println();

        agencia.generarLocalizador(localizador2);

        System.out.println(localizador2);
        System.out.println("Total reserva sin descuentos: " + localizador2.getTotal());
        System.out.println("Descuentos: \n");

        double descuentoLocalizador = localizador2.verificarDescuento();
        System.out.println("Descuento por Paquete Completo o Boletos viajes: $" + descuentoLocalizador);
        double total = localizador2.getTotal();
        double descuentoAgencia = total * agencia.aplicarDescuento(cliente);
        System.out.println("Descuento de agencia: $" + descuentoAgencia);
        double totalGeneral = total - descuentoAgencia - descuentoLocalizador;
        System.out.println("Total con descuentos: " + totalGeneral);
        System.out.println();

        agencia.generarLocalizador(localizador3);
        System.out.println(localizador3);
        System.out.println("Total reserva sin descuentos: " + localizador3.getTotal());
        System.out.println("Descuentos: \n");

        double descuentoLocalizador3 = localizador3.verificarDescuento();
        System.out.println("Descuento por Paquete Completo o Boletos viajes: $" + descuentoLocalizador3);
        double total3 = localizador3.getTotal();
        double descuentoAgencia3 = total3 * agencia.aplicarDescuento(cliente);
        System.out.println("Descuento de agencia: $" + descuentoAgencia3);
        double totalGeneral3 = total3 - descuentoAgencia3 - descuentoLocalizador3;
        System.out.println("Total con descuentos: " + totalGeneral3);
    }


}