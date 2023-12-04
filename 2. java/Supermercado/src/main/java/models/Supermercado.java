package models;

import Exceptions.ClientNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private static Supermercado instance;
    private ContenedorClientes clientes;
    private ContenedorFacturas facturas;
    public static Supermercado getInstance(){
        if(instance==null){
            instance=new Supermercado();
        }
        return instance;
    }
    private Supermercado(){
        clientes= new ContenedorClientes();
        facturas= new ContenedorFacturas();
    }

}
