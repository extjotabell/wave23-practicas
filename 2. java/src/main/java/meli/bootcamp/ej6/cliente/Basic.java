package meli.bootcamp.ej6.cliente;

import meli.bootcamp.ej6.transaccion.ConsultaSaldoImpl;
import meli.bootcamp.ej6.transaccion.ITransaccionable;
import meli.bootcamp.ej6.transaccion.PagoServicioImpl;
import meli.bootcamp.ej6.transaccion.RetiroEfectivoImpl;

public class Basic extends Cliente {

  @Override
  void realizarTransaccion(ITransaccionable transaccionable) {
    if (transaccionable instanceof ConsultaSaldoImpl || transaccionable instanceof PagoServicioImpl
        || transaccionable instanceof RetiroEfectivoImpl) {
      transaccionable.transaccionOk();
    } else {
      transaccionable.transaccionNoOk();
    }
  }

}
