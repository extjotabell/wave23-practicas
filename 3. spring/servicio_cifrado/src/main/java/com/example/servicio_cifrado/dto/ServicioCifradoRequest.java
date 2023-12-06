package com.example.servicio_cifrado.dto;

public class ServicioCifradoRequest {
    private String mensaje;
    private String clave;

    public ServicioCifradoRequest(String mensaje, String clave) {
        this.mensaje = mensaje;
        this.clave = clave;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getClave() {
        return clave;
    }
}
