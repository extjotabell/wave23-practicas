package org.example;

import org.example.clientes.Cliente;
import org.example.localizadores.Localizador;
import org.example.reservas.TipoReserva;

public class Main {

    public static void main(String[] args) {
        Agencia agencia = new Agencia();
        Cliente cliente = agencia.agregarCliente("10", "Miguel");

        agencia.agregarLocalizador("10", agencia.crearReserva(TipoReserva.COMPLETA, 99.99),
                agencia.crearReserva(TipoReserva.HOTEL, 22.50));

        agencia.agregarLocalizador(cliente, agencia.crearReserva(TipoReserva.VUELO, 79.99),
                agencia.crearReserva(TipoReserva.HOTEL, 22.50));

        // Despues de este localizador, aplican descuentos
        Localizador localizador = agencia.agregarLocalizador("10",
                agencia.crearReserva(TipoReserva.HOTEL, 35.99),
                agencia.crearReserva(TipoReserva.HOTEL, 22.50));

        // Vemos el descuento reflejado en el costo total
        System.out.println(localizador.getCostoTotal());


    }
}