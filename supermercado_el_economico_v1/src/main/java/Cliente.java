import java.util.ArrayList;
import java.util.List;

public class Cliente {
    // Atributos de clase
    private static List<Cliente> clientes = new ArrayList<>();

    // Atributos
    private String dni;
    private String nombre;
    private String apellido;

    // Constructor
    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;

        clientes.add(this);
    }

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public static List<Cliente> getClientes() { return clientes; }

    // Métodos
    @Override
    public String toString() {
        return String.format(nombre + " " + apellido + " - DNI: " + dni);
    }

    public boolean eliminar() {
        return clientes.remove(this);
    }

    public static boolean eliminar(String dni) {
        Cliente cliente = buscar(dni);
        return cliente != null && cliente.eliminar();
    }

    public boolean editar(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;

        return true;
    }

    public static Cliente buscar(String dni) {
        return clientes.stream()
            .filter(c -> c.getDni().equals(dni))
            .findFirst()
            .orElse(null);
    }
}
