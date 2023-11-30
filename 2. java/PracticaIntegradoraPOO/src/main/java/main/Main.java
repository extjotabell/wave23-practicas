package main;

public class Main {
    public static void main(String[] args) {
        Persona personaEmpty = new Persona();
        Persona personaThreeAtributes = new Persona("Geronimo",24,"41795111");
        Persona personaFullAtributes = new Persona("Alice",25,"41795112",70.1,1.69);
        String nivelPeso="";


        System.out.print(personaFullAtributes+", ");

        switch (personaFullAtributes.calcularIMC()){
            case 1->{
                nivelPeso = "Sobrepeso";
                break;
            }
            case 0->{
                nivelPeso = "Peso normal";
                break;
            }
            case -1->{
                nivelPeso = "Bajo peso";
                break;
            }
        }

        System.out.print("IMC: " +personaFullAtributes.calcularIMC()+", " + nivelPeso+ ", y ");

        if(personaFullAtributes.mayorDeEdad()){
            System.out.println("es mayor de edad.");
        }else{
            System.out.println("es menor de edad.");
        }

    }
}
