package com.ospina.deportistas.entidad;

public class PersonaDeportistaDTO {
    private String nombre;
    private String apellido;
    private String nombreDeporte;

    public PersonaDeportistaDTO(String nombre, String apellido, String nombreDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreDeporte = nombreDeporte;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

}
