package org.bootcamp;

public class Cobrador implements ITransaccion{

    @Override
    public void consultaSaldo(String cuenta) {
        ITransaccion.super.consultaSaldo(cuenta);
        if (1==2){
            transaccionNoOk();
        }
        else {
            transaccionOk();
        }
    }

    @Override
    public void retiroEfectivo(String cuenta, Double monto) {
        ITransaccion.super.retiroEfectivo(cuenta, monto);
        if (1==2){
            transaccionOk();
        }
        else {
            transaccionNoOk();
        }
    }

}
