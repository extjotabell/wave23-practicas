package org.example;

public class RetiroEfectivo implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Tome el dinero de la caja por favor");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Lo sentimos, no cuenta con el suficiente saldo.");
    }
}
