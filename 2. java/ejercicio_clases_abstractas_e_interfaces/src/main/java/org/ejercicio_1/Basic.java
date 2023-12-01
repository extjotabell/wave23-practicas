package org.ejercicio_1;

public class Basic implements ITransaccion {

    public void consultaDeSaldo(){
        System.out.println("Consultando saldo...");
        transaccionOk();
    }

    public void pagoDeServicios(){
        System.out.println("Realizandose pago de servicios");
        transaccionNoOk();
    }

    public void retiroDeEfectivo(){
        System.out.println("Realizandose retiro de efectivo");
        transaccionNoOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("NO OK");
    }
}
