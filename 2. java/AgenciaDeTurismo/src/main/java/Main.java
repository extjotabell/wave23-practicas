import java.util.*;

public class Main {
    public static void main(String[] args) {
        Agencia agencia = new Agencia();

        IServicio s1= new ReservaBase("reserva",1.0);
        IServicio s2 = new Boletos(s1,"este es un boleto",1.0,"AR","MX");
        IServicio s3 = new Comida(s2,"esta es una comida",1.0,"comida rica");
        IServicio s4 = new Hotel(s3,"Hilton",3,"Hotel de lujo",1.0);
        IServicio s5 = new Transporte(s4,"Este es el transporte",1.0);
        IServicio s6 = new Transporte(s5,"Este es el transporte",1.0);


        IServicio iServicioBase= new ReservaBase("reserva",1.0);
        IServicio iServicioBaseMasboletos1 = new Boletos(iServicioBase,"este es un boleto",1.0,"AR","MX");
        IServicio iServicioBaseMasboletos2 = new Boletos(iServicioBaseMasboletos1,"este es un boleto",1.0,"AR","MX");
        IServicio iServicioBaseMasboletosMasComidaMasHotel = new Hotel(iServicioBaseMasboletos2,"Hilton",3,"Hotel de lujo",1.0);
        IServicio iServicioBaseMasboletosMasComidaMasHotel2 = new Hotel(iServicioBaseMasboletosMasComidaMasHotel,"Hilton",3,"Hotel de lujo",1.0);

        Cliente cliente = new Cliente(1,"Pedro","Dominguez");

        agencia.crearReserva(List.of(iServicioBaseMasboletosMasComidaMasHotel2),cliente,iServicioBaseMasboletosMasComidaMasHotel2.obtenerCosto());
        agencia.crearReserva(List.of(iServicioBaseMasboletosMasComidaMasHotel2),cliente,iServicioBaseMasboletosMasComidaMasHotel2.obtenerCosto());
        agencia.crearReserva(List.of(iServicioBaseMasboletosMasComidaMasHotel2),cliente,iServicioBaseMasboletosMasComidaMasHotel2.obtenerCosto());
        agencia.crearReserva(List.of(s6),cliente,s6.obtenerCosto());

        System.out.println("\n TOTAL FUNCION");
        System.out.println(agencia.obtenerCostoTotal(cliente.getId()));
    }
}
