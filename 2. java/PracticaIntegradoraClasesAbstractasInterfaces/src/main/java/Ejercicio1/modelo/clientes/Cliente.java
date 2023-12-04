package org.example.modelo.clientes;

import org.example.modelo.transacciones.ITransaccion;

abstract class Cliente {
    abstract public void realizarTransaccion(ITransaccion iTransaccion);
}
