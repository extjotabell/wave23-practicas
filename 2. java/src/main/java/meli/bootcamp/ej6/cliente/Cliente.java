package meli.bootcamp.ej6.cliente;

import meli.bootcamp.ej6.transaccion.ITransaccionable;

public abstract class Cliente {
  abstract void realizarTransaccion(ITransaccionable transaccionable);
}
