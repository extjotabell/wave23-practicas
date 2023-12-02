package practica.Banco;

public class Cobrador extends Cliente{
    @Override
    void realizarOperacion(ITransaccionable transaccion) {
        if(transaccion instanceof RetiroDinero || transaccion instanceof ConsultaSaldo){
            transaccion.transaccionOk();
        }else {
            transaccion.transaccionNoOk();
        }
    }
}
