package org.ejercicio_1;

public class PagoServicio implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicio ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicio no ok");
    }
}
