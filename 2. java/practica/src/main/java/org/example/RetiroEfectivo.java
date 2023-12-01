package org.example;

public class RetiroEfectivo implements ITransaccionable{
    @Override
    public void transaccionOk() {
        System.out.println("Realizando retiro de efectivo");
    }

}
