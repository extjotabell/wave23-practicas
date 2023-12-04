package bootcamp;

public class Cliente {
    private int edad;
    private String nombre, apellido;

    private long ID;

    public Cliente(int edad, String nombre, String apellido, long ID) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", ID=" + ID +
                '}';
    }
}
