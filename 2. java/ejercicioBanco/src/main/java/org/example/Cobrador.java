package org.example;

public class Cobrador extends Transaccion implements ITransaccion {

    @Override
    public void retiroEfectivo() {
        System.out.println("Retiro de efectivo - " +  transaccionOk());
    }
    @Override
    public void consultaSaldo() {
        System.out.println("Consulta de saldo - " + transaccionOk());
    }
    @Override
    public void deposito() {
        System.out.println("Deposito - " + transaccionNoOk());
    }
    @Override
    public void transferencia() {
        System.out.println("Transferencia - " + transaccionNoOk());
    }
    @Override
    public void pagoServicios() {
        System.out.println("Pago de servicios - " + transaccionNoOk());
    }
    @Override
    public String toString() {
        return "CLIENTE COBRADOR";
    }
}
