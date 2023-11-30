public class Distribuidora {


    public static void main(String[] args) {

        Producto[] productosVendidos = new Producto[5];

        productosVendidos[0] = new Producto("Café", 30.00);
        productosVendidos[1] = new Producto("Mantequilla", 27.50);
        productosVendidos[2] = new Producto("Pasta", 15.30);
        productosVendidos[3] = new Producto("Milanesas", 150);
        productosVendidos[4] = new Producto("Carne al pastor", 110);
        int iterador = 1;
        for(Producto productoMensaje: productosVendidos){

            System.out.println("Nombre del producto: " + iterador + " " + productoMensaje.getNombre());
            System.out.println("Precio del producto: " + iterador + " " + productoMensaje.getPrecios());
            iterador++;
        }
    }
}
