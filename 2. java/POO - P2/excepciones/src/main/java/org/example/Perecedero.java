package org.example;

/*
Crear la clase Perecedero, que va a tener un atributo llamado diasPorCaducar de tipo int,
al igual que para el producto, definir setters, getters, constructor que reciba todos los
atributos por parámetro y el método toString(). Esta clase debe heredar de Producto y
sobreescribir el método calcular(), el cual tiene que hacer lo mismo que la clase
Producto (multiplicar el precio por la cantidad de productos) y adicionalmente, reducir
el precio según los diasPorCaducar:

Si le resta un día (1) para caducar, se reducirá 4 veces el precio final.
Si le restan dos días (2) para caducar, se reducirá 3 veces el precio final.
Si le restan 3 días (3) para caducar, se reducirá la mitad de su precio final.

*/
public class Perecedero extends Producto {

    int diasPorCaducar;

    public Perecedero(String nombre, double precio) {
        super(nombre, precio);
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        // Llamamos al método calcular de la clase padre para obtener el precio base
        double precioBase = super.calcular(cantidadDeProductos);

        if (diasPorCaducar == 1) {
            double descuento = precioBase * 4;
            return Math.max(0, precioBase - descuento);
        } else if (diasPorCaducar == 2) {
            double descuento = precioBase * 3;
            return Math.max(0, precioBase - descuento);
        } else if (diasPorCaducar == 3) {
            double descuento = precioBase / 2;
            return Math.max(0, precioBase - descuento);
        } else {
            // Si no hay reducciones, devolvemos el precio base
            return Math.max(0, precioBase);
        }
    }
}
