public class Main {
    public static void main(String[] args) {
        Perecedero perecedero1 = new Perecedero("Pan", 0.85, 4);
        Perecedero perecedero2 = new Perecedero("Carne", 7.50, 3);
        Perecedero perecedero3 = new Perecedero("Pescado", 13.50, 1);
        Perecedero perecedero4 = new Perecedero("Fruta", 0.7, 2);
        Perecedero perecedero5 = new Perecedero("Verdura", 1.2, 3);
        NoPerecedero noPerecedero1 = new NoPerecedero("Aceite", 2.29, "Líquido");
        NoPerecedero noPerecedero2 = new NoPerecedero("Arroz", 0.67, "Seco");
        NoPerecedero noPerecedero3 = new NoPerecedero("Latas", 1.89, "Enlatado");
        NoPerecedero noPerecedero4 = new NoPerecedero("Cereal", 2.59, "Seco");
        NoPerecedero noPerecedero5 = new NoPerecedero("Café", 3.99, "Seco");

        Distribuidora distribuidora = new Distribuidora();
        distribuidora.getProductos().add(perecedero1);
        distribuidora.getProductos().add(perecedero2);
        distribuidora.getProductos().add(perecedero3);
        distribuidora.getProductos().add(perecedero4);
        distribuidora.getProductos().add(perecedero5);
        distribuidora.getProductos().add(noPerecedero1);
        distribuidora.getProductos().add(noPerecedero2);
        distribuidora.getProductos().add(noPerecedero3);
        distribuidora.getProductos().add(noPerecedero4);
        distribuidora.getProductos().add(noPerecedero5);

        for (Producto producto : distribuidora.getProductos()) {
            System.out.println(
                "Precio x5 " + producto.getNombre() +
                ": $" + String.format("%.2f", producto.calcular(5))
            );
        }
    }
}