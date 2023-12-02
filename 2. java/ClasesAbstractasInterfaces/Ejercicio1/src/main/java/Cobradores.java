public class Cobradores extends Clientes implements IRetiroEfectivo, IConsultaDeSaldo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultar saldo - Cobradores");
    }

    @Override
    public void realizarRetiroEfectivo() {
        System.out.println("Retirar efectivo - Cobradores");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion OK - Cobradores");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no OK - Cobradores");
    }
}
