package org.example.ejercicio1;

public class RetiroEfectivo implements ITransaccion{
    public void transaccionOk() {
        System.out.println("La transacción fue realizada con Exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción no pudo ser completada");
    }
}
