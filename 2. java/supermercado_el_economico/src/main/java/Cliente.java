public class Cliente {
    // Atributos
    private String dni;
    private String nombre;
    private String apellido;

    // Constructor
    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    // Métodos
    @Override
    public String toString() {
        return String.format(nombre + " " + apellido + " - DNI: " + dni);
    }
}
