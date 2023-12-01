import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Creando 3 clientes de prueba.
        Cliente cliente1 = new Cliente("1111", "José", "Pérez");
        Cliente cliente2 = new Cliente("2222", "Juan", "Ramirez");
        Cliente cliente3 = new Cliente("3333", "María", "Rosas");

        // Agregando los clientes a una Collection.
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        System.out.println("Lista original: ");
        // Recorriendo la lista de clientes y mostrando su información.
        clientes.stream().forEach(System.out::println);

        // Eliminando cliente.
        String dniBorrar1 = "2222";
        List<Cliente> resultadoBusqueda = clientes.stream().filter(c -> c.getDni().equals(dniBorrar1)).toList();
        if(resultadoBusqueda.isEmpty()){
            System.out.println("Cliente no encontrado");
        }else{
            clientes.remove(resultadoBusqueda.get(0));
            System.out.println("Cliente eliminado");
        }

        String dniBorrar2 = "1234";
        resultadoBusqueda = clientes.stream().filter(c -> c.getDni().equals(dniBorrar2)).toList();
        if(resultadoBusqueda.isEmpty()){
            System.out.println("Cliente no encontrado");
        }else{
            clientes.remove(resultadoBusqueda.get(0));
        }


        System.out.println("Lista después de una eliminación: ");
        // Recorriendo la lista de clientes y mostrando su información.
        clientes.stream().forEach(System.out::println);

        // Leyendo datos de teclado
        System.out.printf("Ingresa el DNI del cliente a buscar: ");
        Scanner scanner = new Scanner(System.in);

        String dniBuscado = scanner.nextLine();

        resultadoBusqueda = clientes.stream().filter(c -> c.getDni().equals(dniBuscado)).toList();
        if(resultadoBusqueda.isEmpty()){
            System.out.println("Cliente no encontrado");
        }else{
            System.out.println(resultadoBusqueda.get(0));
        }

    }

}
