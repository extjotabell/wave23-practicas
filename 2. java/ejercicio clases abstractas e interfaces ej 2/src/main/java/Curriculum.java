import java.util.ArrayList;

public class Curriculum extends Documento {

    private String nombre;
    private String apellido;
    private String dni;
    private int edad;

    private ArrayList<String> habilidades;

    public Curriculum(String nombre, String apellido, String dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.habilidades = new ArrayList<>();
    }

    public void agregarHabilidad(String habilidad){
        this.habilidades.add(habilidad);
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", habilidades=" + habilidades +
                '}');
    }
}
