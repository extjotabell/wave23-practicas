package Ejercicio1.Transacciones;

public class Deposito implements ITransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Depósito realizado correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en el depósito.");
    }
}
