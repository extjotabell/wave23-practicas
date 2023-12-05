package org.bootcamp;

public class Basic implements ITransaccion{

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
    public void pagoServicio(String servicio) {
        ITransaccion.super.pagoServicio(servicio);
        if (1==2){
            transaccionOk();
        }
        else {
            transaccionNoOk();
        }
    }

    @Override
    public void retiroEfectivo(String cuenta, Double monto) {
        ITransaccion.super.retiroEfectivo(cuenta, monto);
        if (1==2){
            transaccionNoOk();
        }
        else {
            transaccionOk();
        }
    }

}
