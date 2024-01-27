package org.example.ejercicio1;

public class Cobradores extends Cliente{
    @Override
    public void realizarTransaccion(ITransaccion transaccion) {
        super.realizarTransaccion(transaccion);
        if(transaccion instanceof RetiroEfectivo || transaccion instanceof ConsultaSaldo){
            transaccion.transaccionOk();
        }
        else{
            transaccion.transaccionNoOk();
        }
    }
}
