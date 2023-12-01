package org.example;

import org.example.modelo.clientes.Basic;
import org.example.modelo.clientes.Cobradores;
import org.example.modelo.clientes.Ejecutivo;
import org.example.modelo.transacciones.*;

public class Main {
    public static void main(String[] args) {
        Cobradores cobradores = new Cobradores();
        cobradores.realizarTransaccion(new ConsultaSaldo());
        cobradores.realizarTransaccion(new Transferencia());

        Basic basic = new Basic();
        basic.realizarTransaccion(new RetiroEfectivo());
        basic.realizarTransaccion(new Transferencia());

        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.realizarTransaccion(new Deposito());
        ejecutivo.realizarTransaccion(new PagoServicios());

    }
}