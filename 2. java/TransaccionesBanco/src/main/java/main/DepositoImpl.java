package main;

public class DepositoImpl implements ITransaccionable {

    @Override
    public void transaccionOk() {
        System.out.println("Depósito realizado correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Depósito no pudo ser realizado");
    }
}
