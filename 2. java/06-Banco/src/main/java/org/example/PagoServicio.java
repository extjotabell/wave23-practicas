package org.example;

public class PagoServicio implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("El servicio de Luz fue pagado con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Lo sentimos, Ocurrio un error.");
    }
}
