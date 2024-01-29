package org.example;

public class Transferencia implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("La transferencia se realizo exitosamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar la transferencia");
    }
}
