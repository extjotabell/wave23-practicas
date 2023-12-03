package Ejercicio1.Clientes;

import Ejercicio1.Transacciones.ITransaccion;

public class RetiroDeEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en el retiro de efectivo.");
    }
}
