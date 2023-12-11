package org.mercadolibre.TourismAgency.entity;

/**
 * Represents a complete booking within the Tourism Agency system.
 * A complete booking is a specific type of booking that extends the base Booking class.
 * It inherits the unique identifier (id) and amount attributes from the base class.
 */
public class BookingComplete extends Booking {
    public BookingComplete(int id, Double amount) {
        super(id, amount);
    }
}
