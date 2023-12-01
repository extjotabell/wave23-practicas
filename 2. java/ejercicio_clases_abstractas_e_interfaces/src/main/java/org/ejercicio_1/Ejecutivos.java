package org.ejercicio_1;

public class Ejecutivos implements ITransaccion{

    public void deposito(){
        System.out.println("Realizandose deposito");
        transaccionOk();
    }

    public void transferencia(){
        System.out.println("Realizandose transferencia");
        transaccionNoOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("NO OK");
    }
}
