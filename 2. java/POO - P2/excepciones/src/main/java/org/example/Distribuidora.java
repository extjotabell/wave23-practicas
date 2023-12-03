package org.example;

/*
Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos,
imprimir el precio total al vender 5 productos de cada tipo. Crear los elementos del array
con los datos que quieras.
*/
public class Distribuidora {


    public  double calcularPrecioTotal(Producto[] productos, int cantidad) {
        double precioTotal = 0;

        // Iterar sobre los productos y calcular el precio total
        for (Producto producto : productos) {
            precioTotal += producto.calcular(cantidad);
        }

        return precioTotal;
    }

}
