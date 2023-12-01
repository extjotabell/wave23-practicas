package meli.bootcamp.ej6.cliente;

import meli.bootcamp.ej6.transaccion.DepositoImpl;
import meli.bootcamp.ej6.transaccion.ITransaccionable;
import meli.bootcamp.ej6.transaccion.TransferenciaImpl;

public class Ejecutivo extends Cliente {

  @Override
  void realizarTransaccion(ITransaccionable transaccionable) {
    if (transaccionable instanceof DepositoImpl || transaccionable instanceof TransferenciaImpl) {
      transaccionable.transaccionOk();
    } else {
      transaccionable.transaccionNoOk();
    }
  }

}
