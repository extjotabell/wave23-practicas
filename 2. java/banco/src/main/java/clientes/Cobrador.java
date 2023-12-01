package clientes;

import transacciones.ConsultaDeSaldo;
import transacciones.RetiroDeEfectivo;
import transacciones.Transaccion;

public class Cobrador extends Cliente {

    @Override
    public void transaccion(Transaccion transaccion) {
        boolean condicion =
            transaccion instanceof RetiroDeEfectivo ||
            transaccion instanceof ConsultaDeSaldo;

        if (condicion) transaccion.transaccionOk();
        else transaccion.transaccionNoOk();
    }

    @Override
    public String toString() { return "Cobrador"; }
}
