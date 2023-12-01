package meli.bootcamp.ej6.cliente;

import meli.bootcamp.ej6.transaccion.ConsultaSaldoImpl;
import meli.bootcamp.ej6.transaccion.ITransaccionable;
import meli.bootcamp.ej6.transaccion.RetiroEfectivoImpl;

public class Cobrador extends Cliente {

  @Override
  void realizarTransaccion(ITransaccionable transaccionable) {
    if (transaccionable instanceof RetiroEfectivoImpl || transaccionable instanceof ConsultaSaldoImpl) {
      transaccionable.transaccionOk();
    } else {
      transaccionable.transaccionNoOk();
    }
  }

}
