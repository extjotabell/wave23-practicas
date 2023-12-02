package practica.Banco;

public abstract class Cliente {
    private int dni;

    abstract void realizarOperacion(ITransaccionable transaccion);
}
