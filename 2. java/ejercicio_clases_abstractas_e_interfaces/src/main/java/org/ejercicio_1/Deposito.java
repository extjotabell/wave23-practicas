package org.ejercicio_1;

public class Deposito implements ITransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Falló el deposito");
    }
}
