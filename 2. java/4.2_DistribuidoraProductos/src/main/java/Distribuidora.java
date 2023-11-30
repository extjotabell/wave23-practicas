import java.util.ArrayList;
import java.util.Random;

public class Distribuidora {
    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();

        Perecedero perecedero1 = new Perecedero(3, "Leche", 10.5);
        Perecedero perecedero2 = new Perecedero(2, "Huevo", 5.8);
        Perecedero perecedero3 = new Perecedero(1, "Mantequilla", 2.4);
        Perecedero perecedero4 = new Perecedero(1, "Yogurth", 1.3);
        Perecedero perecedero5 = new Perecedero(1, "Arroz", 3.4);

        NoPerecedero noPerecedero1 = new NoPerecedero("Plástico", "Botella", 15.2);
        NoPerecedero noPerecedero2 = new NoPerecedero("Madera", "Mesa", 9.9);
        NoPerecedero noPerecedero3 = new NoPerecedero("Metal", "Barra", 20.4);
        NoPerecedero noPerecedero4 = new NoPerecedero("Alcohol", "Isopropílico", 9.9);
        NoPerecedero noPerecedero5 = new NoPerecedero("Celular", "Iphone 16", 2000.99);

        Producto producto1 = new Producto("Zapato", 13.3);
        Producto producto2 = new Producto("Camisa", 14.3);
        Producto producto3 = new Producto("Pantalón", 16.3);
        Producto producto4 = new Producto("Calcetín", 21.3);
        Producto producto5 = new Producto("Sudadera", 10.3);

        productos.add(perecedero1);
        productos.add(perecedero2);
        productos.add(perecedero3);
        productos.add(perecedero4);
        productos.add(perecedero5);
        productos.add(noPerecedero1);
        productos.add(noPerecedero2);
        productos.add(noPerecedero3);
        productos.add(noPerecedero4);
        productos.add(noPerecedero5);
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        Random generadorRandom = new Random();

        int min = 1;
        int max = 10;

        double precioTotal = 0;
        for(Producto p : productos){
            int cantidad = (int)Math.floor(Math.random() * (max - min + 1) + min);
            precioTotal += p.calcular(cantidad);
        }

        System.out.println(String.format("Total de productos: %s", precioTotal));

    }
}
