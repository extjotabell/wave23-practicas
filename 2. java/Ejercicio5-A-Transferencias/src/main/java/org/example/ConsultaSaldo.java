package org.example;

public class ConsultaSaldo implements ITransaccionable{
    @Override
    public void transaccionOk() {
        System.out.println("Realizando consulta de saldo");
    }
}
