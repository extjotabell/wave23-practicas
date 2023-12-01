package Ejercicio1.transacciones;

public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Se realiza consulta de saldo");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realizo consulta de saldo");

    }
}
