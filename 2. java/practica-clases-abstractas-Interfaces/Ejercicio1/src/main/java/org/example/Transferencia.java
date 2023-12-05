package org.example;

public class Transferencia implements ITransaccionable{
    @Override
    public void transaccionOk() {
        System.out.println("Realizando transferencia");
    }

}
