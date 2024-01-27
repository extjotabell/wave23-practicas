package org.example.ejercicio1;

public class PagoServicio implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("La transacción fue realizada con Exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción no pudo ser completada");
    }
}
