package org.example;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    final static int CERO = 0;
    final static int VEINTE = 20;
    final static int VEITICINTO = 25;

    public Persona() {
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
        double calculo = this.peso / (this.altura * this.altura);
        if (this.peso == CERO || this.altura == CERO) {
            throw new IllegalStateException("No se puede calcular el IMC ya que el peso o la altura no esta cargada");
        }
        if (calculo < VEINTE) {
            System.out.println("Bajo peso");
            return -1;
        } else if (calculo < VEITICINTO) {
            System.out.println("Peso saludable");
            return CERO;
        } else {
            System.out.println("Sobrepeso");
            return 1;
        }

    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    public String nivelPeso() {
        return switch (calcularIMC()) {
            case -1 -> "Bajo Peso.";
            case CERO -> "Peso saludable.";
            case 1 -> "Sobrepeso.";
            default -> "No definido.";
        };
    }


    @Override
    public String toString() {
        return "Persona " +
                "Nombre: " + nombre + '\'' +
                "Dni: " + dni + '\'' +
                "Edad: " + edad +
                "Peso: " + peso +
                "Altura: " + altura +
                "Es mayor de edad: " + (esMayorDeEdad() ? "Si." : "No.") +
                "Nivel de peso: " + nivelPeso();
    }

}
