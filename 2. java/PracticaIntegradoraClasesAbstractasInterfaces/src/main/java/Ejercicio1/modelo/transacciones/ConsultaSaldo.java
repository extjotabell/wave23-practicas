package org.example.modelo.transacciones;

public class ConsultaSaldo implements ITransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Realizando consulta de saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en consulta de saldo");
    }
}
