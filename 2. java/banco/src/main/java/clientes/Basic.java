package clientes;

import transacciones.*;

public class Basic extends Cliente {

    @Override
    public void transaccion(Transaccion transaccion) {
        boolean condicion =
            transaccion instanceof ConsultaDeSaldo ||
            transaccion instanceof PagoDeServicios ||
            transaccion instanceof RetiroDeEfectivo;

        if (condicion) transaccion.transaccionOk();
        else transaccion.transaccionNoOk();
    }

    @Override
    public String toString() { return "Basic"; }
}
