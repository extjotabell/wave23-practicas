public class Persona {
/*  */

    String name;
    int age;
    String dni;
    double weight;
    double height;

    public Persona(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public Persona(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Persona() {
    }

    public int calcularIMC(){
        double formula = weight/(height*height);
        if(formula<20){
            return -1;
        }else if(formula<=25){
            return 0;
        }else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return age>=18;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", Edad: " + age + ", DNI: " + dni +
                ", Peso: " + weight + ", Altura: " + height +
                ", Es mayor de edad? " + (esMayorDeEdad() ?"Si": "No");
    }
}
