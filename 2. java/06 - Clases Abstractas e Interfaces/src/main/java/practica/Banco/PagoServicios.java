package practica.Banco;

public class PagoServicios implements ITransaccionable {

    @Override
    public void transaccionOk() {
        System.out.println("El pago de servicios de realizó con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El pago de servicios no pudo ser realizado");
    }
}
