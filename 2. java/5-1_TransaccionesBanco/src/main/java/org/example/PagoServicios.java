package org.example;

public class PagoServicios implements ITransaccionable{
    @Override
    public void transaccionOk() {
        System.out.println("Realizando pago de servicio");
    }

}
