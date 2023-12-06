package org.example.Ej1;

public class Transferencia extends Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia OK");
    }

    @Override
    public void transaciconNoOK() {
        System.out.println("Transferencia no OK");
    }
}
