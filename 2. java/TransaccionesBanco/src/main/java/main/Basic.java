package main;

public class Basic extends Cliente {
    @Override
    public void realizarTransaccion(ITransaccionable ITransaccionable) {
        if (ITransaccionable instanceof ConsultaDeSaldoImpl || ITransaccionable instanceof PagoDeServiciosImpl || ITransaccionable instanceof RetiroDeEfectivoImpl) {
            ITransaccionable.transaccionOk();
        }
        else {
            ITransaccionable.transaccionNoOk();
        }
    }
}
