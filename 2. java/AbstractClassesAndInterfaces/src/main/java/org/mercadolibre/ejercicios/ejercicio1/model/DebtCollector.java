package org.mercadolibre.ejercicios.ejercicio1.model;

public class DebtCollector extends Customer implements IWithdrawCash, ICheckBalance{

    public DebtCollector(int id, String nombre, String dni) {
        super(id, nombre, dni);
    }

    @Override
    public void transactionOk() {
        System.out.println("Transacción de cobro exitosa");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Error en la transacción de cobro");
    }

    public void withdrawCash() {
        System.out.println("Retirando efectivo");
    }

    public void checkBalance() {
        System.out.println("Consultando saldo");
    }
}
