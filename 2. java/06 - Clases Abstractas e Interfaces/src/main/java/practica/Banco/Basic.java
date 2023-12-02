package practica.Banco;

public class Basic extends Cliente{
    @Override
    void realizarOperacion(ITransaccionable transaccion) {
        if (transaccion instanceof ConsultaSaldo || transaccion instanceof PagoServicios || transaccion instanceof RetiroDinero) {
            transaccion.transaccionOk();
        }
        else {
            transaccion.transaccionNoOk();
        }
    }
}
