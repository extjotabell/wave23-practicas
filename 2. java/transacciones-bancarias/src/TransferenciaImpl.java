package org.example;

public class TransferenciaImpl implements ITransaccionable {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia no pudo ser realizada");
    }
}
