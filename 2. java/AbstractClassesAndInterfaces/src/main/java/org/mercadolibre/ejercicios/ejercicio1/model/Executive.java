package org.mercadolibre.ejercicios.ejercicio1.model;

public class Executive extends Customer implements IDeposit, ITransfer{

    public Executive(int id, String nombre, String dni) {
        super(id, nombre, dni);
    }

    @Override
    public void transactionOk() {
        System.out.println("Transacción ejecutiva exitosa");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Error en la transacción ejecutiva");
    }

    public void makeDeposit() {
        System.out.println("Realizando depósito");
    }

    public void makeTransfer() {
        System.out.println("Realizando transferencia");
    }
}
