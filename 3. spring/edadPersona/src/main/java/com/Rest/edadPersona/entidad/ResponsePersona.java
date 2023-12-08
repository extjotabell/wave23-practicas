package com.Rest.edadPersona.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePersona {

        private String nombre;
        private String apellido;
        private Integer edad;


}
