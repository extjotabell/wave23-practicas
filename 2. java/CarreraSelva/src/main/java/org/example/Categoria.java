package org.example;

public class Categoria {

    int id;
    static int contadorId;
    String nombre, descripcion;

    public Categoria(String nombre, String descripcion){
        this.id = ++Categoria.contadorId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public static double precioCategoria(int edad, String nombre){
        double monto = 0;
        switch (nombre){
            case "Circuito Chico":
                if(edad < 18){
                    monto = 1300;
                }
                else {
                    monto = 1500;
                }
                break;
            case "Circuito Medio":
                if (edad < 18) {
                    monto =  2000;
                }
                else {
                    monto =  2300;
                }
                break;
            case "Circuito Avanzado":
                monto =  2800;
                break;
        }
        return monto;
    }

}
