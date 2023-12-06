package org.example.Ej1;

public class Cobrador {

    public void retirarEfectivo() {
        Transaccion retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.transaccionOk();
    }

    public void consultarSaldo() {
        Transaccion consultaSaldo = new ConsultaSaldo();
        consultaSaldo.transaciconNoOK();
    }
}
