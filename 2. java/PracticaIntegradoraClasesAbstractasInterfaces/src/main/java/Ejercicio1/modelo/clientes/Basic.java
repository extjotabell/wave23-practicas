package org.example.modelo.clientes;

import org.example.modelo.transacciones.ConsultaSaldo;
import org.example.modelo.transacciones.ITransaccion;
import org.example.modelo.transacciones.PagoServicios;
import org.example.modelo.transacciones.RetiroEfectivo;

public class Basic extends Cliente{

        @Override
        public void realizarTransaccion(ITransaccion iTransaccion) {
            if (iTransaccion instanceof ConsultaSaldo || iTransaccion instanceof PagoServicios || iTransaccion instanceof RetiroEfectivo) {
                iTransaccion.transaccionOk();
            } else {
                iTransaccion.transaccionNoOk();
            }
        }
}
