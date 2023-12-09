import models.Customer;
import models.Invoice;
import models.Product;
import repositories.CustomerRepository;
import repositories.InvoiceRepository;
import repositories.ProductRepository;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static final CustomerRepository customerRepository = new CustomerRepository(new LinkedList<>());
    private static final ProductRepository productRepositorio = new ProductRepository(new LinkedList<>());
    private static final InvoiceRepository invoiceRepository = new InvoiceRepository(new LinkedList<>());

    public static void main(String[] args) {
        Customer clientOne = new Customer(123456, "Matias", "Fiermarin");
        Customer clientTwo = new Customer(456789, "Raul", "Perez");
        Customer clientThree = new Customer(987654, "Maria", "Lopez");
        Product product1 = new Product("1001", "Leche", 100, 45);
        Product product2 = new Product("1002", "Huevos", 100, 85);
        Product product3 = new Product("1003", "Manteca", 100, 55);

        customerRepository.add(clientOne);
        customerRepository.add(clientTwo);
        customerRepository.add(clientThree);
        productRepositorio.add(product1);
        productRepositorio.add(product2);
        productRepositorio.add(product3);

        System.out.println("Listado de todos los clientes: ");
        customerRepository.consult().forEach(System.out::println);

        System.out.println();
        System.out.println("Eliminamos al cliente "+ customerRepository.consult().get(1).getName());
        customerRepository.consult().remove(1);

        System.out.println();
        System.out.println("Listamos de nuevo todos los clientes");
        customerRepository.consult().forEach(System.out::println);

        System.out.println();

        try {
            System.out.print("Ingrese número de DNI a buscar: ");
            int dni = scanner.nextInt();

            Optional<Customer> customerOptional = customerRepository.consultDNI(dni);
            customerOptional.ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Cliente no encontrado")
                    );
        }catch (InputMismatchException e){
            System.out.println("Solo se puede ingresar números");
        }

        addInvoice();
    }

    private static void addInvoice(){
        Customer customer;

        try {
            System.out.print("Ingrese número de DNI del cliente: ");
            int dni = scanner.nextInt();

            customer = checkCustomer(dni);

            Map<Product, Integer> shoppingList = new HashMap<>();
            shoppingList.put(productRepositorio.consult().get(0), 2);
            shoppingList.put(productRepositorio.consult().get(1), 6);
            shoppingList.put(productRepositorio.consult().get(2), 4);

            Invoice invoice = new Invoice(customer, shoppingList);
            invoiceRepository.add(invoice);

            System.out.println();
            System.out.println("Se realizo la venta  correctamente.");
            System.out.println("Total de la venta: " + invoice.getTotal());
            System.out.println("Cliente: " + invoice.getCustomer().getName() +
                    " " + invoice.getCustomer().getLastName());
            System.out.println("Lista de productos: ");
            for(Map.Entry<Product, Integer> entry: invoice.getProducts().entrySet()){
                Product product = entry.getKey();
                int quantity = entry.getValue();
                System.out.println("Producto: " + product.getName() +
                        "/ Costo unitario: " + product.getUnitCost() +
                        "/ Cantidad comprada: " + quantity + "/ Total: " +
                        product.getUnitCost() * quantity
                );
            }
        }catch (InputMismatchException e){
            System.out.println("Solo se puede ingresar números");
        }
    }


    private static Customer checkCustomer(int dni){
        Customer customer;

        Optional<Customer> customerOptional = customerRepository.consultDNI(dni);

        if(customerOptional.isPresent()){
            System.out.println("Cliente ya ingreso en el sistema");

            customer = customerOptional.get();
        }else {
            System.out.print("Ingrese nombre del cliente: ");
            String name = scanner.nextLine();
            System.out.print("Ingrese apellido del cliente: ");
            String lastName = scanner.nextLine();

            customer = new Customer();
            customer.setDni(dni);
            customer.setName(name);
            customer.setLastName(lastName);

            customerRepository.add(customer);
        }

        return customer;
    }
}