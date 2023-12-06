package org.example.Ej1;

public class Basico {

    public void consultarSaldo() {
        Transaccion consultaSaldo = new ConsultaSaldo();
        consultaSaldo.transaciconNoOK();
    }

    public void pagarServicio() {
        Transaccion pagar = new PagoServicios();
        pagar.transaccionOk();
    }

    public void retirarEfectivo() {
        Transaccion retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.transaccionOk();
    }
}
