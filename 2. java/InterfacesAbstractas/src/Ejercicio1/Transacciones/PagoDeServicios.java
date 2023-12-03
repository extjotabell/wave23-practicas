package Ejercicio1.Transacciones;

public class PagoDeServicios implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago de serivicios realizado correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en el pago de servicios.");
    }
}
