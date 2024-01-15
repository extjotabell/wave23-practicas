package com.meli.Empleados.entity;

import com.meli.Empleados.dto.EmpleadoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity @Document(indexName = "empleados")
public class Empleado {

    @Id
    private String id;

    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String provincia;

    public Empleado(EmpleadoDto empleadoDto) {
        this.nombre = empleadoDto.getNombre();
        this.apellido = empleadoDto.getApellido();
        this.edad = empleadoDto.getEdad();
        this.ciudad = empleadoDto.getCiudad();
        this.provincia = empleadoDto.getProvincia();
    }
}
