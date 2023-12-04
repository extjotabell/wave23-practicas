package org.example.modelo.transacciones;

public class PagoServicios implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose pago de servicios");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en pago de servicios");
    }
}
