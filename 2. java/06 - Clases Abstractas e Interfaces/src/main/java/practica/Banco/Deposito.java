package practica.Banco;

public class Deposito implements ITransaccionable {
    @Override
    public void transaccionOk() {
        System.out.println("El depósito de realizó con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El depósito no pudo ser realizado");
    }
}
