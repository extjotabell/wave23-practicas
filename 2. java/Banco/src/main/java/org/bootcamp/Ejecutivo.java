package org.bootcamp;

public class Ejecutivo implements ITransaccion{


    @Override
    public void deposito(String cuenta) {
        ITransaccion.super.deposito(cuenta);
        if (1==2){
            transaccionNoOk();
        }
        else {
            transaccionOk();
        }
    }

    @Override
    public void transferencia(String cuentaOrigen, String cuentaDestino) {
        ITransaccion.super.transferencia(cuentaOrigen, cuentaDestino);
        if (1==2){
            transaccionOk();
        }
        else {
            transaccionNoOk();
        }
    }

}
