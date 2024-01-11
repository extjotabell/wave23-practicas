package com.relaciones.jpa.entities.claves_compuestas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
@IdClass(value = PersonaKey.class) // Clase que indica el valor de la clave compuesta
public class Persona {

    @Id
    private Integer dni;
    @Id
    private Integer numTramite;

    public Integer getDni() {
        return dni;
    }

    public void setId(Integer dni) {
        this.dni = dni;
    }

    public Integer getNumTramite() {
        return numTramite;
    }

    public void setNumTramite(Integer numTramite) {
        this.numTramite = numTramite;
    }
}
