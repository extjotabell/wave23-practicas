package Ejercicio1.transacciones;

public class PagoDeServicios implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Se realizo pago de servicios");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realizo pago de servicios");

    }
}
