package org.example;

public class Basic extends Cliente{
    public void realizarConsulta(){
        ConsultaSaldo consulta = new ConsultaSaldo();
        consulta.transaccionOk();
    }
    public void noRealizarConsulta(){
        ConsultaSaldo consulta = new ConsultaSaldo();
        consulta.transaccionNoOk();
    }
    public void pagarServicio(){
        PagoServicio pagoServicio = new PagoServicio();
        pagoServicio.transaccionOk();
    }
    public void noPagarServicio(){
        PagoServicio pagoServicio = new PagoServicio();
        pagoServicio.transaccionNoOk();
    }
    public void retirarEfectivo(){
        RetiroEfectivo retirar = new RetiroEfectivo();
        retirar.transaccionOk();
    }
    public void noRetirarEfectivo(){
        RetiroEfectivo retirar = new RetiroEfectivo();
        retirar.transaccionNoOk();
    }
}
