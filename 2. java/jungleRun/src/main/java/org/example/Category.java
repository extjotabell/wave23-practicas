package org.example;

public class Category {
    private Integer id;
    private String name;
    private String description;

    private Integer smallerAmount;
    private Integer higherAmount;

    public Category(String name, String description, Integer smallerAmount, Integer higherAmount) {
        this.name = name;
        this.description = description;
        this.smallerAmount = smallerAmount;
        this.higherAmount = higherAmount;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSmallerAmount() {
        return smallerAmount;
    }

    public Integer getHigherAmount() {
        return higherAmount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + "\n" +
                "Descripcion: " + description + "\n";
    }
}
