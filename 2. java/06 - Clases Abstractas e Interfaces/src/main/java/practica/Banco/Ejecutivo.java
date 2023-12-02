package practica.Banco;

public class Ejecutivo extends Cliente{
    @Override
    void realizarOperacion(ITransaccionable transaccion) {
        if (transaccion instanceof Deposito || transaccion instanceof Transferencia) {
            transaccion.transaccionOk();
        }
        else {
            transaccion.transaccionNoOk();
        }
    }
}
