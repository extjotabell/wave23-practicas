package org.mercadolibre.SaveTheRopaSA.model;

public abstract class Garment {
    private String brand;
    private String model;

    public Garment(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Marca: " + brand + ", modelo: " + model;
    }
}
