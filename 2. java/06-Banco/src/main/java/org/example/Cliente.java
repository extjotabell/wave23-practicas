package org.example;

public abstract class Cliente {
    protected void realizarTransaccion(ITransaccion transaccion){
        transaccion.transaccionOk();
    }
    public void noRealizarTransaccion(ITransaccion transaccion){
        transaccion.transaccionNoOk();
    }
}
