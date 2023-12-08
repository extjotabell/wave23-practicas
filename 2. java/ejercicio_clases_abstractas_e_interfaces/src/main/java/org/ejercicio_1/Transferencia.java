package org.ejercicio_1;

public class Transferencia implements ITransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia fallida :c");
    }
}
