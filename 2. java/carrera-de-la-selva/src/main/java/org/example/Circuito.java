package org.example;

public class Circuito {
    public static final String CIRCUITO_CHICO = "Circuito chico";
    public static final String CIRCUITO_MEDIO = "Circuito medio";
    public static final String CIRCUITO_AVANZADO = "Circuito avanzado";

    private int id;

    private String desc;
    private String tipo;

    public Circuito(int id,String tipo, String desc) {
        this.id = id;
        this.tipo = tipo;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDesc() {
        return desc;
    }
}
