package main;

public class ConsultaDeSaldoImpl implements ITransaccionable {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizada correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo no pudo ser realizada");
    }
}
