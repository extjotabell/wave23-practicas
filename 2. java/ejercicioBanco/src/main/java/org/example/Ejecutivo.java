package org.example;

public class Ejecutivo extends Transaccion implements ITransaccion{

    @Override
    public void deposito() {
        System.out.println("Deposito - " + transaccionOk());
    }
    @Override
    public void transferencia() {
        System.out.println("Transferencia - " +  transaccionOk());
    }
    @Override
    public void retiroEfectivo() {
        System.out.println("Retiro de efectivo - " +  transaccionNoOk());
    }
    @Override
    public void consultaSaldo() {
        System.out.println("Consulta de saldo - " + transaccionNoOk());
    }
    @Override
    public void pagoServicios() {
        System.out.println("Pago de servicios - " + transaccionNoOk());
    }
    @Override
    public String toString() {
        return "CLIENTE EJECUTIVO";
    }
}
