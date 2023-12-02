package org.mercadolibre.ejercicios.ejercicio1;

import org.mercadolibre.ejercicios.ejercicio1.model.Basic;
import org.mercadolibre.ejercicios.ejercicio1.model.DebtCollector;
import org.mercadolibre.ejercicios.ejercicio1.model.Executive;

public class BankApp {
    public static void main(String[] args) {
        Executive executive = new Executive(1,"José", "1234567");
        executive.makeDeposit();
        executive.transactionOk();

        Basic basic = new Basic(2,"María", "6493956");
        basic.checkBalance();
        basic.transactionNoOk();

        DebtCollector debtCollector = new DebtCollector(3,"Camila", "9784636");
        debtCollector.withdrawCash();
        debtCollector.transactionOk();
    }

}
