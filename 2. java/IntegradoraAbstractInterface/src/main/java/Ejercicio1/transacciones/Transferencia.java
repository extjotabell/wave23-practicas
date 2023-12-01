package Ejercicio1.transacciones;

public class Transferencia implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Se realizo la transferencia");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realizo la transferencia");

    }
}
