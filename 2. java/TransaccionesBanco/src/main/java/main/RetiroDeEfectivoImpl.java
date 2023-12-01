package main;

public class RetiroDeEfectivoImpl implements ITransaccionable {
    @Override
    public void transaccionOk() {
        System.out.println("No se pudo retirar efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Efectivo retirado correctamente");
    }
}
