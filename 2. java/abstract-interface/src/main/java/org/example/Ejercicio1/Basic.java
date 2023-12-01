package org.example;

public class Basic extends Clientes implements IRetiroEfectivo, IConsultaDeSaldo, IPagoDeServicios {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultar saldo - Basic");
    }

    @Override
    public void pagarServicios() {
        System.out.println("Pagar servicios - Basic");
    }

    @Override
    public void realizarRetiroEfectivo() {
        System.out.println("Retirar efectivo - Basic");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion OK - Basic");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no OK - Basic");
    }
}