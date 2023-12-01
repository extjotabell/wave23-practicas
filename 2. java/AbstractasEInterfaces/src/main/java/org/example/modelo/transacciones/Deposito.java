package org.example.modelo.transacciones;

public class Deposito implements ITransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Realizándose depósito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en depósito");
    }
}
