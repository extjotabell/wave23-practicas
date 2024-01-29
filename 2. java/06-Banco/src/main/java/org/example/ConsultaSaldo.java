package org.example;

public class ConsultaSaldo implements ITransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Su saldo es de $10,000");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Lo sentimos, ocurrio un error al consultar su saldo");
    }
}
