import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static int idCount = 0;
    private static List<Cliente> clientes = new ArrayList<>();

    private final int id;
    private String nombre;

    public Cliente(String nombre) {
        ++idCount;
        this.id = idCount;
        this.nombre = nombre;

        clientes.add(this);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
