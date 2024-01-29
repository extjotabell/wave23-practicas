package Ejercicio1.transacciones;

public class Deposito implements Transaccion {


    @Override
    public void transaccionOk() {
        System.out.println("Se realizo el deposito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realizo el deposito");

    }
}