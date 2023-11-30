public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float estatura;

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, float estatura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.estatura = estatura;
    }

    public int calcularIMC(){
        float imc = (this.peso / (this.estatura * estatura));

        if(imc < 20){
            return -1;
        }else if(imc >= 20 && imc <= 25){
            return 0;
        }else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    @Override
    public String toString(){
        return String.format("Nombre: %s, Edad: %d años, DNI: %s, Peso: %f kg, Estatura: %f m",
                this.nombre, this.edad, this.dni, this.peso, this.estatura);
    }

}
