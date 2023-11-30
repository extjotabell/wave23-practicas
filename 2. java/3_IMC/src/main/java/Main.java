public class Main {
    public static void main(String[] args) {

        Persona personaVacia = new Persona();
        Persona personaIncompleta = new Persona("Juan", 24, "321711");
        Persona personaCompleta = new Persona("Pedro", 24, "438912", 70.5f, 1.80f);

        //Tratamos de crear una Persona con un constructor que no existe.
        // La siguiente línea muestra un error indicando que no existe un constructor válido.
        //Persona personaIncorrecta = new Persona("Paco", 42);

        int criterioIMC = personaCompleta.calcularIMC();
        boolean esMayorEdad = personaCompleta.esMayorDeEdad();
        System.out.println(personaCompleta);
        if(esMayorEdad){
            System.out.println("La persona es mayor de edad");
        }else{
            System.out.println("La persona es menor de edad");
        }
        if(criterioIMC == -1){
            System.out.println("La persona está baja de peso");
        }else if(criterioIMC == 0){
            System.out.println("La persona tiene un peso saludable");
        }else{
            System.out.println("La persona tiene sobrepeso");
        }


    }
}
