package org.example;

public class Colaboradores {
    public void consultarSaldo(){
        ConsultaSaldo consulta = new ConsultaSaldo();
        consulta.transaccionOk();
    }
    public void  noConsultaSaldo(){
        ConsultaSaldo consulta = new ConsultaSaldo();
        consulta.transaccionNoOk();
    }
    public void retirarEfectivo(){
        RetiroEfectivo retiro = new RetiroEfectivo();
        retiro.transaccionOk();
    }
    public void noRetirarEfectivo(){
        RetiroEfectivo retiro = new RetiroEfectivo();
        retiro.transaccionNoOk();
    }
}
