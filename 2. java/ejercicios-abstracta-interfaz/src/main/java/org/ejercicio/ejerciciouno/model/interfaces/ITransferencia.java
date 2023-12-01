package org.ejercicio.ejerciciouno.model.interfaces;

public interface ITransferencia extends ITransaccion{

    void transferir(String numeroCuenta, double cantidad);
}
