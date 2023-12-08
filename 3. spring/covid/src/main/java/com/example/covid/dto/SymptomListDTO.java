package com.example.covid.dto;

import com.example.covid.entities.Gravedad;
import com.example.covid.entities.Sintoma;

import java.util.List;

public class SymptomListDTO {
    private List<SymptomDTO> sintomas;

    public SymptomListDTO(List<SymptomDTO> sintomas) {
        this.sintomas = sintomas;
    }

    public List<SymptomDTO> getSintomas() {
        return sintomas;
    }

    public static class SymptomDTO {
        private String codigo;
        private String nombre;
        private Gravedad gravedad;

        public SymptomDTO(String codigo, String nombre, Gravedad gravedad) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.gravedad = gravedad;
        }

        public String getCodigo() {
            return codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public Gravedad getGravedad() {
            return gravedad;
        }
    }
}
