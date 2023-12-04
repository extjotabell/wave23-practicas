package org.example.modelo.transacciones;

public class RetiroEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose retiro");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en retiro");
    }
}
