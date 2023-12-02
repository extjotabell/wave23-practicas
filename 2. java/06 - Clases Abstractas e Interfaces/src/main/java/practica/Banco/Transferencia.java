package practica.Banco;

public class Transferencia implements ITransaccionable {

    @Override
    public void transaccionOk() {
        System.out.println("La transferencia de realizó con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transferencia no pudo ser realizado");
    }
}
