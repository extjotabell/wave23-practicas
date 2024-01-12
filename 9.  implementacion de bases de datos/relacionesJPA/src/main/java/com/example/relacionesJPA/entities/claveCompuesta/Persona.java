package com.example.relacionesJPA.entities.claveCompuesta;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "personas")
@IdClass(value = PersonaKey.class)
public class Persona {
    @Id
    private Integer dni;

    @Id
    private Integer numTramite;

}
