package Ejercicio1.transacciones;


public class RetiroDeEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Se realiza retiro de efectivo");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realiza retiro de efectivo");

    }
}