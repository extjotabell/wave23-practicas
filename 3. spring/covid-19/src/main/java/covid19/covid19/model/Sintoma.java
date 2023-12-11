package covid19.covid19.model;

public class Sintoma {
    private int codigo;
    private String nombre;
    private NivelGravedad nivelDeGravedad;

    public Sintoma(int codigo, String nombre, NivelGravedad nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivelGravedad() {
        return this.nivelDeGravedad.name();
    }
}
