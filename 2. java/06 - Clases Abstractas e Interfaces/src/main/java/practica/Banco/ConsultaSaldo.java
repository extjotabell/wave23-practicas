package practica.Banco;

public class ConsultaSaldo implements ITransaccionable {

    @Override
    public void transaccionOk() {
        System.out.println("La consulta de saldo se realizó con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La consulta no pudo ser realizada");
    }
}
