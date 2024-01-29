package org.example;

public class Deposito implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Se realizo el deposito correctamente");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ocurrio un error al Realizar el Deposito.");
    }
}
