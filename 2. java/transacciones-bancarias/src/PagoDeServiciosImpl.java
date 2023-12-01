package org.example;

public class PagoDeServiciosImpl implements ITransaccionable {
    @Override
    public void transaccionOk() {
        System.out.println("Pago de Servicios realizado correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de Servicios no pudo ser realizado");
    }
}
