// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Persona mateo = new Persona();
        Persona raul = new Persona("Matias", 31, "12345678");
        Persona marcos = new Persona("Raul", 45, "98347634", 86, 186);

        // Error
        //Persona persona_cuatro = new Persona("Jose", 12);

        try{
            System.out.println(marcos.toString());
            System.out.println("IMC");
            switch (marcos.calcularIMC()){
                case -1:
                    System.out.println("Bajo Peso");
                    break;
                case 0:
                    System.out.println("Peso saludable");
                    break;
                case 1:
                    System.out.println("Sobrepeso");
                    break;
            }
            if(marcos.esMayorDeEdad()){
                System.out.println(marcos.getNombre() + " es mayor de edad.");
            }else {
                System.out.println(marcos.getNombre() + " es menor de edad.");
            }
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }
}