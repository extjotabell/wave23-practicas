package org.example;

public class Cobrador extends Cliente {
    @Override
    public void realizarTransaccion(ITransaccionable ITransaccionable) {
        if (ITransaccionable instanceof RetiroDeEfectivoImpl || ITransaccionable instanceof ConsultaDeSaldoImpl) {
            ITransaccionable.transaccionOk();
        }
        else {
            ITransaccionable.transaccionNoOk();
        }
    }
}
