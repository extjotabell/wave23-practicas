package org.example.ejercicio1;

public class Basic extends Cliente{
    @Override
    public void realizarTransaccion(ITransaccion transaccion) {
        super.realizarTransaccion(transaccion);
        if(transaccion instanceof ConsultaSaldo || transaccion instanceof PagoServicio || transaccion instanceof RetiroEfectivo){
            transaccion.transaccionOk();
        }
        else{
            transaccion.transaccionNoOk();
        }
    }
}
