package Ejercicio1.Transacciones;

public class Transferencia implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizado correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en la transferencia.");
    }
}
