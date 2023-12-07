package org.example;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public class Agencia {

    private int totalReserva = 0;
    private int localizadoresVendidos = 0;

    private static ArrayList<Reserva> hotel = new ArrayList<>();
    private static ArrayList<Reserva> avion = new ArrayList<>();
    private static ArrayList<Reserva> comida = new ArrayList<>();
    private static ArrayList<Reserva> traslado = new ArrayList<>();

    private static HashMap<String, ArrayList<Localizador>> historial = new HashMap<>();


    public static void realizarCompra(Localizador localizador){
        String dni = localizador.getCliente().getDni();

        if(historial.containsKey(dni)) {
            ArrayList<Localizador> h = historial.get(dni);
            h.add(localizador);
        } else {
            ArrayList<Localizador> h = new ArrayList<>();
            h.add(localizador);
            historial.put(dni,h);

        }

        for (Reserva reserva: localizador.getReservas()){
            if(reserva.getTipo().equals(TipoProducto.HOTEL)){
                hotel.add(reserva);
            }

            if(reserva.getTipo().equals(TipoProducto.BOLETO_AVION)){
                avion.add(reserva);
            }

            if(reserva.getTipo().equals(TipoProducto.COMIDA)){
                comida.add(reserva);
            }

            if(reserva.getTipo().equals(TipoProducto.TRASLADOS)){
                traslado.add(reserva);
            }
        }

    }

    public static int cantidadLocalizadoresCompradosAnteriormentePorCliente(String dni) {
        if(!historial.containsKey(dni)){
            return 0;
        }

        return historial.get(dni).size();
    }

    public static void generarInforme(){

        int cantReservas = hotel.size() + avion.size() + comida.size() + traslado.size();
        double totalVendido = calculoTotalVendido();
        int cantLocalizadoresVendidos = cantidadLocalizadoresVendidos();

        System.out.println("Cantidad de localizadores vendidos: " + cantLocalizadoresVendidos);
        System.out.println("Cantidad total de reservas: " + cantReservas);
        System.out.println("Reservas de HOTEL (" + hotel.size() +"): ");
        System.out.println(hotel.toString());

        System.out.println("Reservas de AVIÓN (" + avion.size() +"): ");
        System.out.println(avion.toString());

        System.out.println("Reservas de COMIDA: (" + comida.size() +"): ");
        System.out.println(comida.toString());

        System.out.println("Reservas de TRASLADOS(" + traslado.size() + "): ");
        System.out.println(traslado.toString());

        System.out.println("Total de ventas: " + totalVendido);

        System.out.println("Promedio de ventas: " + (totalVendido/cantLocalizadoresVendidos));
    }
    private static int cantidadLocalizadoresVendidos(){
        int cantidad = 0;

        for(Map.Entry<String,ArrayList<Localizador>> entry: historial.entrySet() ){
            cantidad += entry.getValue().size();
        }
        return cantidad;
    }

    private static double calculoTotalVendido(){
        double total = 0;

        for(Map.Entry<String,ArrayList<Localizador>> localizadores: historial.entrySet() ){
            for (Localizador l: localizadores.getValue()){
                total += l.getPrecioTotal();
            }
        }
        return total;
    }
}
