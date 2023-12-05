package org.mercadolibre.TourismAgency.model;

public class Booking {

    private Integer id;
    private Double amount;

    public Booking(int id, Double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
