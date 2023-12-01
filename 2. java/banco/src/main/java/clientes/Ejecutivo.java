package clientes;

import transacciones.*;

public class Ejecutivo extends Cliente{

    @Override
    public void transaccion(Transaccion transaccion) {
        boolean condicion =
            transaccion instanceof Deposito ||
            transaccion instanceof Transferencia;

        if (condicion) transaccion.transaccionOk();
        else transaccion.transaccionNoOk();
    }

    @Override
    public String toString() { return "Ejecutivo"; }
}
