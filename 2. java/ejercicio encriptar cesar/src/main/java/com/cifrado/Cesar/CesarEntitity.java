package com.cifrado.Cesar;

public class CesarEntitity {
    private String texto;
    private String clave;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public CesarEntitity(String texto, String clave) {
        this.texto = texto;
        this.clave = clave;
    }
}
