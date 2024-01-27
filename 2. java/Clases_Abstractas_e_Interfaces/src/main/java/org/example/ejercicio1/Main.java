package org.example.ejercicio1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<ITransaccion> transacciones = new ArrayList<>();

        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic = new Basic();
        Cobradores cobrador = new Cobradores();

        Deposito deposito = new Deposito();
        PagoServicio pagoServicio = new PagoServicio();
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        Transferencia transferencia = new Transferencia();

        clientes.add(ejecutivo);
        clientes.add(basic);
        clientes.add(cobrador);

        transacciones.add(deposito);
        transacciones.add(pagoServicio);
        transacciones.add(consultaSaldo);
        transacciones.add(retiroEfectivo);
        transacciones.add(transferencia);

        for(Cliente cliente: clientes){
            for(ITransaccion transaccion: transacciones){
                System.out.println(cliente.getClass().getSimpleName() + " realizando " + transaccion.getClass().getSimpleName());
                cliente.realizarTransaccion(transaccion);
                System.out.println();
            }
        }

    }
}