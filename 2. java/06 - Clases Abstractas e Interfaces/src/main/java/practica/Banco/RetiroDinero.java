package practica.Banco;

public class RetiroDinero implements ITransaccionable {
    @Override
    public void transaccionOk() {
        System.out.println("El retiro de dinero de realizó con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El retiro de dinero no pudo ser realizado");
    }
}
