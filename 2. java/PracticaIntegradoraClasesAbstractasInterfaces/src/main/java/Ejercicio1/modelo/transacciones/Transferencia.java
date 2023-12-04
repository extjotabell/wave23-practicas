package org.example.modelo.transacciones;

public class Transferencia implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en transferencia");
    }
}
