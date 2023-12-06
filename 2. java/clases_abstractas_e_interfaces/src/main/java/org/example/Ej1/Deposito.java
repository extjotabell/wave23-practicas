package org.example.Ej1;

public class Deposito extends Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Deposito OK");
    }

    @Override
    public void transaciconNoOK() {
        System.out.println("Deposito rechazado");
    }
}
