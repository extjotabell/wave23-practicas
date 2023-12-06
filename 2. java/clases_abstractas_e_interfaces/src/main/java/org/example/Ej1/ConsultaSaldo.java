package org.example.Ej1;

public class ConsultaSaldo extends Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consulta saldo OK");
    }

    @Override
    public void transaciconNoOK() {
        System.out.println("Consulta saldo No OK");
    }
}
