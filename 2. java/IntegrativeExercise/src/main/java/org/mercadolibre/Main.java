package org.mercadolibre;

import org.mercadolibre.dao.CustomerCRUD;
import org.mercadolibre.dao.InvoiceCRUD;
import org.mercadolibre.dao.ItemCRUD;
import org.mercadolibre.entity.Customer;
import org.mercadolibre.entity.Invoice;
import org.mercadolibre.entity.Item;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Main class that serves as an entry point for the MercadoLibre application.
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final CustomerCRUD clientCRUD = new CustomerCRUD();
    private static final InvoiceCRUD invoiceCRUD = new InvoiceCRUD();
    private static final ItemCRUD itemCRUD = new ItemCRUD();

    /**
     * Main method to run the MercadoLibre application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        createClients();
        createItems();

        int option;
        do {
            printMenu();
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    createClient();
                    break;
                case 2:
                    printClients();
                    break;
                case 3:
                    removeRandomClient();
                    break;
                case 4:
                    findClientByDni();
                    break;
                case 5:
                    createItem();
                    break;
                case 6:
                    createInvoice(findClientByDni());
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción correcta.");
            }
        } while (option != 0);
        sc.close();
    }

    /**
     * Prints the main menu options.
     */
    private static void printMenu() {
        System.out.println("\nElija una opción:");
        System.out.println("1. Crear cliente");
        System.out.println("2. Ver lista de clientes");
        System.out.println("3. Eliminar cliente aleatorio");
        System.out.println("4. Buscar cliente por DNI");
        System.out.println("5. Crear ítem");
        System.out.println("6. Crear factura");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }

    /**
     * Initializes the application with some pre-defined clients.
     */
    private static void createClients() {
        clientCRUD.create(new Customer("1", "Arami", "Aquino"));
        clientCRUD.create(new Customer("12", "Franco", "Simionato"));
        clientCRUD.create(new Customer("123", "Fernando", "Dominguez"));
    }

    /**
     * Initializes the application with some pre-defined items.
     */
    private static void createItems() {
        itemCRUD.create(new Item("1", "CocaCola", 1, 100.0));
        itemCRUD.create(new Item("1", "Pepsi", 1, 100.0));
    }

    /**
     * Prints the list of clients in the data store.
     */
    private static void printClients() {
        System.out.println("Lista de clientes:");
        clientCRUD.getAll().forEach(System.out::println);
    }

    /**
     * Removes a randomly selected client from the data store.
     */
    private static void removeRandomClient() {
        List<Customer> clients = clientCRUD.getAll();
        Random rand = new Random();
        Customer randomClient = clients.get(rand.nextInt(clients.size()));
        clientCRUD.delete(randomClient.getDni());
        System.out.println("\nLista de clientes después de eliminar uno:");
    }

    /**
     * Searches for a client by DNI in the data store.
     *
     * @return The found client or null if not found.
     */
    private static Customer findClientByDni() {
        System.out.print("\nIngrese el número de DNI a buscar: ");
        String dniFound = sc.nextLine();
        Customer customerFound = clientCRUD.read(dniFound);
        if (customerFound != null) {
            System.out.println("Cliente encontrado: " + customerFound);
            return customerFound;
        } else {
            System.out.println("No se encontró un cliente con el DNI " + dniFound);
        }
        return null;
    }

    /**
     * Creates an invoice associated with a client and the list of items.
     *
     * @param client The client associated with the invoice.
     */
    private static void createInvoice(Customer client) {
        if (client != null) {
            Invoice invoice = new Invoice(client, itemCRUD.getAll());
            invoiceCRUD.create(invoice);
            System.out.println("Se a creado la factura numero: " + invoice.getVoiceNro() +
                    " " + "Por un total de " + invoice.getTotal());

        } else {
            System.out.println("No se puede crear factura, cliente no encontrado.");
        }
    }

    /**
     * Creates a new client based on user input.
     */
    private static void createClient() {
        System.out.println("\nCrear cliente:");
        System.out.println("Ingresar DNI:");
        String dni = sc.nextLine();
        System.out.println("Ingresar nombre:");
        String name = sc.nextLine();
        System.out.println("Ingresar apellido:");
        String lastName = sc.nextLine();

        Customer customer = new Customer(dni, name, lastName);
        Customer createdClient = clientCRUD.create(customer);
        if (createdClient != null) {
            System.out.println("Cliente creado: " + createdClient);
        }
    }

    /**
     * Creates a new item based on user input.
     */
    private static void createItem() {
        System.out.println("\nCrear ítem:");
        System.out.println("Ingresar codigo:");
        String id = sc.nextLine();
        System.out.println("Ingresar nombre:");
        String name = sc.nextLine();
        System.out.println("Ingresar cantidad:");
        int quantity = sc.nextInt();
        System.out.println("Ingresar precio:");
        double price = sc.nextDouble();

        Item item = new Item(id, name, quantity, price);
        itemCRUD.create(item);

        System.out.println("ítem creado: " + item);
    }
}