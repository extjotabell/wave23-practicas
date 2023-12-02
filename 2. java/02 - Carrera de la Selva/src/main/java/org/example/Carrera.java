package org.example;

import java.util.*;

public class Carrera {

    private int id;
    private String nombre;
    private List<Inscripcion> inscripcionList;
    private List<Categoria> categoriaList;

    public Carrera(String nombre) {
        this.id = new Random().nextInt(1000);
        this.nombre = nombre;
        this.inscripcionList = new ArrayList<>();
        this.categoriaList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Inscripcion> getInscripcionList() {
        return inscripcionList;
    }

    public void setInscripcionList(List<Inscripcion> inscripcionList) {
        this.inscripcionList = inscripcionList;
    }

    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public String desinscribirParticipante(int id) {
        Inscripcion inscripcionAEliminar = null;
        String mensaje = "";
        for (Inscripcion inscripcion : inscripcionList) {
            if (inscripcion.getId() == id) {
                inscripcionAEliminar = inscripcion;
                break;
            }
        }

        if (inscripcionAEliminar != null) {
            inscripcionList.remove(inscripcionAEliminar);
            mensaje = "Desinscripción exitosa.";
        } else {
            mensaje = "No se encontró la inscripción con el número " + id;
        }

        return mensaje;
    }

    public String mostrarTotalRecaudado() {
        String mensaje = "\nMontos recaudados por categoría:";
        double montoTotalCarrera = 0;

        for (Categoria categoria : this.categoriaList) {
            double montoCategoria = calcularMontoTotalCategoria(categoria);
            montoTotalCarrera += montoCategoria;
            mensaje += ("\n" + categoria.getNombre() + ": $" + montoCategoria);
        }

        mensaje += ("\nTotal general: $" + montoTotalCarrera);

        return mensaje;
    }

    private double calcularMontoTotalCategoria(Categoria categoria){
        double totalRecaudado = 0;
        for (Inscripcion i: this.inscripcionList){
            if(i.getCategoria().getId() == categoria.getId()){
                totalRecaudado += i.getMonto();
            }
        }
        return totalRecaudado;
    }

    private Map<Categoria, List<Participante>> getParticipantesPorCategoria() {
        Map<Categoria, List<Participante>> participantesPorCategoria = new HashMap<>();

        for (Categoria categoria : this.categoriaList) {
            participantesPorCategoria.put(categoria, new ArrayList<>());
        }

        for (Inscripcion inscripcion : this.inscripcionList) {
            Categoria categoria = inscripcion.getCategoria();
            Participante participante = inscripcion.getParticipante();

            participantesPorCategoria.get(categoria).add(participante);
        }

        return participantesPorCategoria;
    }

    public String toStringModificado(){
        StringBuilder mensaje = new StringBuilder();

        Map<Categoria, List<Participante>> participantesPorCategoria = getParticipantesPorCategoria();

        for (Categoria categoria : this.categoriaList) {
            mensaje.append("Categoria: '").append(categoria.getNombre()).append("',\n");
            mensaje.append("Descripcion: '").append(categoria.getDescripcion()).append("'\n");

            List<Participante> participantes = participantesPorCategoria.get(categoria);
            if (participantes.isEmpty()) {
                mensaje.append("No hay participantes inscriptos\n");
            } else {
                mensaje.append("Participantes:\n");
                for (Participante participante : participantes) {
                    mensaje.append("Participante: ").append(participante.getNumero()).append(",\n");
                    mensaje.append("Nombre: '").append(participante.getNombre()).append("',\n");
                    mensaje.append("Apellido: '").append(participante.getApellido()).append("',\n");
                    mensaje.append("Edad: ").append(participante.getEdad()).append("\n");
                }
            }

            mensaje.append("//////////\n");
        }

        return mensaje.toString();
    }

    @Override
    public String toString() {
        return "\nCarrera: " + id +
                ", \nNombre: '" + nombre + '\'' +
                ", \nInscripcionList: " + inscripcionList.toString() +
                ", \nCategoriaList: " + categoriaList.toString();
    }
}
