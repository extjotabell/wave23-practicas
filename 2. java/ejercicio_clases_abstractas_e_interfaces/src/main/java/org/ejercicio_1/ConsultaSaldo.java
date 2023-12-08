package org.ejercicio_1;

public class ConsultaSaldo implements ITransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo fallida");
    }
}
