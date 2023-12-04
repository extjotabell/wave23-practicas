import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>(){{
            add(new Cliente(12345678, "Pedro", "Luro"));
            add(new Cliente(23456789, "Jose", "Ramirez"));
            add(new Cliente(34567890, "Diego", "Gonzales"));
        }};

        System.out.println("Todos mis clientes");
        clientes.forEach(x -> System.out.println("\t" + x));

        clientes.remove(1);

        System.out.println("Mis clientes con uno eliminado");
        clientes.forEach(x -> System.out.println("\t" + x));

        Scanner sc = new Scanner(System.in);

        int input = -1;
        try {
            System.out.println("Ingrese el dni del cliente que quiere encontrar");
            input = sc.nextInt();
        }catch(Exception ignored){
        }
        if(input == -1){
            System.out.println("Ese no es un dni válido");
            return;
        }

        int finalInput = input;
        Optional<Cliente> res = clientes.stream().filter(cliente -> cliente.getDni() == finalInput).findFirst();
        if(res.isPresent()){
            System.out.println(res.get());
        }else{
            System.out.println("No existe un cliente con ese dni");
        }

    }
}