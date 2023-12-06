package com.cifrado.cesar.model;

public class CifradoEntity {
    private String mensaje;
    private String clave;

    public CifradoEntity(String mensaje, String clave) {
        this.mensaje = mensaje.toUpperCase().replaceAll(" ", "");;
        this.clave = clave;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
