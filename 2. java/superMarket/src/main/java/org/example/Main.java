package org.example;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NotClientException {
        // Parte 1
        Supermarket chinoLuna = new Supermarket();
        Client tomasv = new Client(43735806, "Tomas", "Vazquez");
        chinoLuna.addClient(tomasv);
        chinoLuna.addClient(new Client(43735807, "Sofia", "Vega"));
        chinoLuna.addClient(new Client(43735808, "Miley", "Cyrus"));

        System.out.println("------ getClients -----");
        chinoLuna.getClients();

        System.out.println("------ deleteClient -----");
        chinoLuna.deleteClient(tomasv);

        System.out.println("----- searchClient -----");
        chinoLuna.searchClientByDNI(43735807);

        // Parte 2
        Client notCliente = new Client(43735666, "Pepe", "Argento");
        List<Product> products = new ArrayList<>();
        Product lays = new Product(1, "Lays", 2, 34.0);
        products.add(lays);
        try {
            chinoLuna.generateExpense(notCliente, products);
        } catch (NotClientException ex) {
            System.out.println("Excepcione!");
            chinoLuna.addClient(notCliente);
            chinoLuna.generateExpense(notCliente, products);
            chinoLuna.getAllExpenses();
        }
    }
}