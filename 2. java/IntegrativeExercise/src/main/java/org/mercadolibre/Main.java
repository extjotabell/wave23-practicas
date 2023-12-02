package org.mercadolibre;

import org.mercadolibre.model.Customer;
import org.mercadolibre.model.Product;
import org.mercadolibre.model.Supermarket;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Customer customer1 = new Customer("12345654", "Juan", "Perez");
        Customer customer2 = new Customer("65735625", "María", "González");
        Customer customer3 = new Customer("34567543", "Camila", "Gómez");
        List<Customer> customers = new ArrayList<>(List.of(customer1, customer2, customer3));

        Product product1 = new Product("2345", "Teclado", 1, 200000.0);
        Product product2 = new Product("5678", "Silla gamer", 2, 500000.0);
        Product product3 = new Product("8901", "Monitor", 1, 200000.0);
        List<Product> products = new ArrayList<>(List.of(product1, product2, product3));

        Supermarket supermarket = new Supermarket(customers, products, "El económico");

        System.out.println("********** Listado de clientes **********");
        supermarket.getCustomers().forEach(System.out::println);

        supermarket.removeCustomer(customer2);

        System.out.println("********** Nuevo listado de clientes **********");
        supermarket.getCustomers().forEach(customer -> System.out.println(customer.toString()));

        System.out.println("********** Buscador de clientes **********");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente: ");
        supermarket.getCustomerByDni(scanner.next());

    }
}