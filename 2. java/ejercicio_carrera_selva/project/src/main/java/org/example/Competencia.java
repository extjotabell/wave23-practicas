package org.example;

public class Competencia {
    private int id;
    private String nombre_circuito;
    private String descripcion_circuito;

    public Competencia(int id, String nombre_circuito, String descripcion_circuito) {
        this.id = id;
        this.nombre_circuito = nombre_circuito;
        this.descripcion_circuito = descripcion_circuito;
    }

    @Override
    public String toString() {
        return "Competencia{" +
                "id=" + id +
                ", nombre_circuito='" + nombre_circuito + '\'' +
                ", descripcion_circuito='" + descripcion_circuito + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_circuito() {
        return nombre_circuito;
    }

    public void setNombre_circuito(String nombre_circuito) {
        this.nombre_circuito = nombre_circuito;
    }

    public String getDescripcion_circuito() {
        return descripcion_circuito;
    }

    public void setDescripcion_circuito(String descripcion_circuito) {
        this.descripcion_circuito = descripcion_circuito;
    }
}
