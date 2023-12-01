package org.example;

public class Cobrador extends Cliente{
    public Cobrador(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarRetiroEfectivo() {
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.noTransaccionOk();
    }
    @Override
    public void realizarConsultaSaldo(){
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        consultaSaldo.noTransaccionOk();
    }
}
