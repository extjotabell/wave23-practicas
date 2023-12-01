public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona (){

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        if(this.peso == 0 || this.altura == 0){
            throw new IllegalStateException("No se puede calcular el IMC ya que el peso o la altura no esta cargada");
        }
        double resultado = 0;
        resultado = this.peso/(Math.pow(this.altura,2));

        if(resultado < 20){
            return -1;
        }else if(resultado < 25){
            return  0;
        }else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Datos de la Persona: \n" +
                "Nombre: '" + nombre + '\n' +
                "Edad: " + edad + '\n' +
                "DNI: '" + dni + '\'' + '\n' +
                "Peso: " + peso + '\n' +
                "Altura: " + altura;
    }

    public String getNombre() {
        return nombre;
    }
}
