package org.mercadolibre.productDistributor;

import org.mercadolibre.productDistributor.model.NonPerishable;
import org.mercadolibre.productDistributor.model.Perishable;
import org.mercadolibre.productDistributor.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Distributor {

    //psvm
    public static void main(String[] args) {

        Product product1 = new Perishable(1,"Facturas", 3000.0);
        Product product2 = new Perishable(3,"Fideos", 1000.0);
        Product product3 = new Perishable(3,"Chocolate", 4035.0);
        Product product4 = new Perishable(1,"Leche", 3070.87);
        Product product5 = new Perishable(3,"Chocolate", 5678.978);
        Product product6 = new NonPerishable("Electrodomestico", "Televisor", 2000.0);
        Product product7 = new NonPerishable("Mueble", "Silla", 2000.0);
        Product product8 = new NonPerishable("Electrodomestico", "Cafetera", 2000.0);
        Product product9 = new NonPerishable("Electrodomestico", "Pava Electrica", 2000.0);
        Product product10 = new NonPerishable("Mueble", "Mesa", 2000.0);

        List<Product> products = new ArrayList<>(List.of(product1, product2, product3, product4, product5, product6, product7, product8, product9, product10));

        int quantitySold = 5;
        double totalPrice = 0;

        for (Product product : products) {
            totalPrice += product.calculator(quantitySold);
        }

        System.out.println("Precio total al vender " + quantitySold + " productos de cada tipo: " + Math.round(totalPrice * 100.0) / 100.0);

    }
}
