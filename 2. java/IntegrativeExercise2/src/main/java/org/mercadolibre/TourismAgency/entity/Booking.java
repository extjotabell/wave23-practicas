package org.mercadolibre.TourismAgency.entity;

/**
 * Represents a booking within the Tourism Agency system.
 * Each booking is associated with a unique identifier (id) and a corresponding amount.
 */
public class Booking {

    /** Unique identifier for the booking. */
    private Integer id;
    /** The total amount associated with the booking. */
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

    @Override
    public String toString() {
        return "Booking -> Nº " + id + ", amount: " + amount;
    }
}