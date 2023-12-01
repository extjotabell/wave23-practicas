package org.example;

public class Ejecutivo extends Cliente {
    @Override
    public void realizarTransaccion(ITransaccionable ITransaccionable) {
        if (ITransaccionable instanceof DepositoImpl || ITransaccionable instanceof TransferenciaImpl) {
            ITransaccionable.transaccionOk();
        }
        else {
            ITransaccionable.transaccionNoOk();
        }
    }
}
