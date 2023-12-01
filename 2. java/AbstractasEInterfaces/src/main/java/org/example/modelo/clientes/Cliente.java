package org.example.modelo.clientes;

import org.example.modelo.transacciones.ITransaccion;

abstract class Cliente {
    abstract void realizarTransaccion(ITransaccion iTransaccion);
}
