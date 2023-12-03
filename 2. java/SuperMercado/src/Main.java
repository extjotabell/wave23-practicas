import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Customer clientOne = new Customer(123456, "Matias", "Fiermarin");
        Customer clientTwo = new Customer(456789, "Raul", "Perez");
        Customer clientThree = new Customer(987654, "Maria", "Lopez");

        List<Customer> customers = new ArrayList<>();
        customers.add(clientOne);
        customers.add(clientTwo);
        customers.add(clientThree);

        System.out.println("Listado de todos los clientes: ");
        customers.forEach(System.out::println);

        System.out.println();
        System.out.println("Eliminamos al cliente "+ customers.get(1).getName());
        customers.remove(1);

        System.out.println();
        System.out.println("Listamos de nuevo todos los clientes");
        customers.forEach(System.out::println);

        System.out.println();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese número de DNI a buscar: ");
            int dni = scanner.nextInt();

            customers.stream().
                    filter(x -> x.getDni() == dni)
                    .findFirst()
                    .ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Cliente no encontrado")
                    );
        }catch (InputMismatchException e){
            System.out.println("Solo se puede ingresar números");
        }
    }
}