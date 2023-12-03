package Ejercicio2;

import java.util.List;

public class Curriculum implements Imprimir{
    private String nombre;
    private List<String> habilidades;
    public Curriculum(String nombre, List<String> habilidades){
        this.nombre=nombre;
        this.habilidades=habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
    @Override
    public void imprimir(){
        System.out.println("Curriculum:  '\n'" +
        "Nombre: " + nombre + '\n' +
        "Habilidades: ");
        habilidades.forEach(System.out::println);
    }
}
