package Ejercicio1.Transacciones;

public class ConsultaDeSaldo implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizado correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en la consulta de saldo.");
    }
}
