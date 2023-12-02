public class Ejecutivos extends Clientes implements IDeposito, ITransferencia {

    @Override
    public void realizarDeposito() {
        System.out.println("Consultar saldo - Ejecutivos");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizar transferencia - Ejecutivos");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion OK - Ejecutivos");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no OK - Ejecutivos");
    }
}
