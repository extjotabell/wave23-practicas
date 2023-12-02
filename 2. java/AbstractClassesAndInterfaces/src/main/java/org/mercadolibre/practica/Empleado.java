package org.mercadolibre.practica;

public class Empleado extends Persona{

    private int employeeID;
    private String office;

    public Empleado(int id, String name, int age, int employeeID, String office) {
        super(id, name, age);
        this.employeeID = employeeID;
        this.office = office;
    }

    @Override
    public String speak() {
        return "hablando";
    }
}
