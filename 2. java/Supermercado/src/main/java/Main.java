import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Cliente> clienteList = new ArrayList<>();
        List<Item> itemsList = new ArrayList<>();
        List<Factura> facturaList = new ArrayList<>();


        //Parte 1
        //1-Crear 3 clienteList y guardarlos en una collection.

        Cliente cliente1 = new Cliente(11111111,"Geronimo","Schmidt");
        Cliente cliente2 = new Cliente(22222222,"Alice","Schmidt");
        Cliente cliente3 = new Cliente(33333333,"John","Schmidt");
        Cliente cliente4 = new Cliente(44444444,"Carmen","Schmidt");
        clienteList.add(cliente1);
        clienteList.add(cliente2);
        clienteList.add(cliente3);

        //2-Recorrer la collection de clienteList y mostrar por pantalla los datos de cada uno de ellos.
        clienteList.stream().forEach(System.out::println);

        //3-Eliminar uno de los clienteList de la lista y volver a consultar e imprimir todos los clienteList restantes.
        System.out.println("Lista luego de eliminar");
        clienteList.remove(cliente3);
        clienteList.stream().forEach(System.out::println);

        //4-Solicitar por teclado un número de dni de un cliente para buscarlo.
        // En caso de que el cliente se encuentre en la lista,
        // mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.
/*
        System.out.println("Ingresar dni de un cliente: ");
        long dni = scan.nextLong();
        clienteList.stream().filter(cliente -> cliente.getDni() == dni).forEach(System.out::println);

 */

        //Parte 2
        //1- Crear nueva factura
        Item item1 = new Item(1,"item1",1,1);
        Item item2 = new Item(2,"item1",2,2);
        Item item3 = new Item(3,"item1",2,3);
        itemsList.add(item1);
        itemsList.add(item2);
        itemsList.add(item3);
        double totalCompra = itemsList.stream().mapToDouble(Item::getCostoUnitario).sum();
        Factura factura = new Factura(cliente1,itemsList,totalCompra);

        //2-
        if(clienteList.contains(factura.getCliente())==true){
            System.out.println("El cliente existe.");
            facturaList.add(factura);
        }else{
            System.out.println("Creando cliente...");
            Cliente clienteNuevo = new Cliente(factura.getCliente().getDni(),factura.getCliente().getNombre(),factura.getCliente().getApellido());
            clienteList.add(clienteNuevo);
        }




    }
}
