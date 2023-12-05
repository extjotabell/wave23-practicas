package org.example;

public abstract class Cliente {
    private String nombre;


    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void realizarDeposito(){
        Deposito deposito = new Deposito();
        deposito.transaccionOk();
    }

    public void realizarTransferencia(){
        Transferencia transferencia = new Transferencia();
        transferencia.transaccionOk();
    }

    public void realizarConsultaSaldo(){
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        consultaSaldo.transaccionOk();
    }

    public void realizarRetiroEfectivo(){
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.transaccionOk();
    }
    public  void realizarPagoServicios(){
        PagoServicios pagoServicios = new PagoServicios();
        pagoServicios.transaccionOk();
    }
}
