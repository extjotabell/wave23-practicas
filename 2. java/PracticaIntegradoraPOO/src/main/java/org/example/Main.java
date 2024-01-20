package org.example;

public class Main {
    public static void main(String[] args) {

        String esMayoroNo;
        String estadoSalud;

        Persona zeus = new Persona();
        Persona dominic = new Persona("Dominic", 36, "282019");
        Persona isis = new Persona("Isis", 14, "201020", 69, 1.70);

       // Persona danilo = new Persona("Danilo", 28); // No se peude implementar porque no existe el constructor indicado.

        // Define si es mayor de edad o no.
        if(isis.esMayorDeEdad() == true){
           esMayoroNo = "\nEs mayor de edad ";
        } else {
           esMayoroNo = "\nNo es mayor de edad ";
        }

        // Define que tipo de IMC se le debe asignar con los parametros entregados.
        if(isis.calcularIMC() ==  -1){
            estadoSalud = "y ae encuentra en un nivel de peso bajo";
        } else if (isis.calcularIMC() == 0){
            estadoSalud ="y se encuentra en un nivel de peso saludable";
        } else {
            estadoSalud ="y se encuentra en un nivel de sobrepeso";
        }

        //Imprime mensaje con info.

        System.out.println(isis.toString() + esMayoroNo + estadoSalud);
    }
}