package org.example.modelo.clientes;

import org.example.modelo.transacciones.Deposito;
import org.example.modelo.transacciones.ITransaccion;
import org.example.modelo.transacciones.Transferencia;

public class Ejecutivo extends Cliente{

    @Override
    public void realizarTransaccion(ITransaccion iTransaccion) {
        if (iTransaccion instanceof Deposito || iTransaccion instanceof Transferencia) {
            iTransaccion.transaccionOk();
        } else {
            iTransaccion.transaccionNoOk();
        }
    }
}
