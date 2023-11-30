import java.util.ArrayList;
import java.util.List;

public class Distribuidora {


    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        double calculoTotal = 0;

        Perecedero perecedero1 = new Perecedero("nombre 1", 250.4, 2);
        Perecedero perecedero2 = new Perecedero("nombre 2", 100, 5);
        Perecedero perecedero3 = new Perecedero("nombre 3", 120, 1);
        Perecedero perecedero4 = new Perecedero("nombre 4", 130, 3);
        Perecedero perecedero5 = new Perecedero("nombre 5", 240, 2);

        NoPerecedero noPerecedero1 = new NoPerecedero("nombre 6", 100, "tipo 1");
        NoPerecedero noPerecedero2 = new NoPerecedero("nombre 7", 101, "tipo 2");
        NoPerecedero noPerecedero3 = new NoPerecedero("nombre 8", 10, "tipo 3");
        NoPerecedero noPerecedero4 = new NoPerecedero("nombre 9", 29, "tipo 4");
        NoPerecedero noPerecedero5 = new NoPerecedero("nombre 10", 78, "tipo 5");

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

        for (Producto producto : productos) {
            calculoTotal += producto.calcular(1);
            System.out.println(producto);

        }
        System.out.println("Costo total: " + calculoTotal);
    }
}