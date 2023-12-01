package clientes;

import transacciones.Transaccion;

public abstract class Cliente {
    public abstract void transaccion(Transaccion transaccion);
}
