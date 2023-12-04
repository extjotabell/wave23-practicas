package org.supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SuperMercado {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Factura> facturas = new ArrayList<>();

    public SuperMercado(List<Cliente> clientes, List<Factura> facturas) {
        this.clientes = clientes;
        this.facturas = facturas;
    }

    public void eliminarCliente(Cliente cliente){

        clientes.remove(cliente);
    }

    public void imprimirClientes(){

        clientes.forEach(System.out::println);
    }

    public void buscarCliente(int dni){
        Optional<Cliente> buscado = clientes.stream()
                .filter(cliente -> cliente.getDni() == dni).findFirst();
        buscado.ifPresentOrElse(
                (cliente)
                        -> {
                    System.out.println("Cliente encontrado: ");
                    System.out.println(cliente);

                },
                ()
                        ->{
                    System.out.println("Cliente no encontrado");
                });


    }

    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public boolean buscarCliente(Cliente c){
        Optional<Cliente> buscado = clientes.stream()
                .filter(cliente -> cliente.equals(c)).findFirst();
        return buscado.isPresent();
    }

    public void agregarFactura(Factura factura){
        if (buscarCliente(factura.getCliente())){
            facturas.add(factura);
            System.out.println("Cliente ya registrado");
        }else{
            clientes.add(factura.getCliente());
            facturas.add(factura);
            System.out.println("Agregando factura y cliente");
        }
    }
}
