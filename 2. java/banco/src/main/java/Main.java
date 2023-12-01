import transacciones.*;
import clientes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Transaccion> transacciones = new ArrayList<>();

        transacciones.add(new Deposito());
        transacciones.add(new Transferencia());
        transacciones.add(new RetiroDeEfectivo());
        transacciones.add(new PagoDeServicios());
        transacciones.add(new ConsultaDeSaldo());

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Ejecutivo());
        clientes.add(new Basic());
        clientes.add(new Cobrador());

        for (Cliente cliente : clientes) {
            System.out.println("--------------- " + cliente + " ---------------");

            for (Transaccion transaccion : transacciones) {
                cliente.transaccion(transaccion);
            }
        }
    }
}