package org.example.ejercicio1;

public class Ejecutivo extends Cliente{
    @Override
    public void realizarTransaccion(ITransaccion transaccion) {
        super.realizarTransaccion(transaccion);
        if(transaccion instanceof Deposito || transaccion instanceof Transferencia){
            transaccion.transaccionOk();
        }
        else{
            transaccion.transaccionNoOk();
        }
    }
}
