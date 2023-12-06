package org.example.Ej1;

public class RetiroEfectivo extends Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Efectivo retirado");
    }

    @Override
    public void transaciconNoOK() {
        System.out.println("Retiro efectivo rechazado");
    }
}
