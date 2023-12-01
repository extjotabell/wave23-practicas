import java.util.List;

public class Curriculum extends Documento {
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, String dni, int edad, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public void agregarHabilidad(String habilidad) {
        this.habilidades.add(habilidad);
    }

    @Override
    public void imprimir() {
        System.out.println("----- " + imprimirTipoDoc() +" -----");

        System.out.println("Nombre: " + this.nombre + " " + this.apellido);
        System.out.println("DNI: " + this.dni);
        System.out.println("Edad: " + this.edad);

        System.out.println("Habilidades: ");
        habilidades.forEach(h -> System.out.println("- " + h));
    }

    @Override
    public String imprimirTipoDoc() {
        return "Curriculum";
    }
}
