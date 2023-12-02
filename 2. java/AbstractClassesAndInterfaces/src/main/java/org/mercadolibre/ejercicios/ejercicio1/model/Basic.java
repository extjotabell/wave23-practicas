package org.mercadolibre.ejercicios.ejercicio1.model;

public class Basic extends Customer implements ICheckBalance, IWithdrawCash, IPayServices{

    public Basic(int id, String name, String dni) {
        super(id, name, dni);
    }


    @Override
    public void transactionOk() {
        System.out.println("La transferencia se realizó correctamente");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Error: La transferencia no se pudo realizar");
    }

    public void checkBalance() {
        System.out.println("Consultando saldo");
    }

    public void payServices() {
        System.out.println("Realizando pago de servicios");
    }

    public void withdrawCash() {
        System.out.println("Retirando efectivo");
    }
}
