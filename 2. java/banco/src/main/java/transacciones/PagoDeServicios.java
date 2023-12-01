package transacciones;

public class PagoDeServicios implements Transaccion {
    @Override
    public void transaccionOk() { System.out.println("Pago de servicios realizado con exito"); }

    @Override
    public void transaccionNoOk() { System.out.println("Pago de servicios no realizado"); }
}
