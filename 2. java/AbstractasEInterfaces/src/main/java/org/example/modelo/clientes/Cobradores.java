package org.example.modelo.clientes;

import org.example.modelo.transacciones.ConsultaSaldo;
import org.example.modelo.transacciones.ITransaccion;
import org.example.modelo.transacciones.RetiroEfectivo;

public class Cobradores extends Cliente{
    @Override
    void realizarTransaccion(ITransaccion iTransaccion) {
        if (iTransaccion instanceof RetiroEfectivo || iTransaccion instanceof ConsultaSaldo) {
            iTransaccion.transaccionOk();
        } else {
            iTransaccion.transaccionNoOk();
        }
    }
}
