package org.mercadolibre.TourismAgency.entity;

/**
 * Represents a flight booking within the Tourism Agency system.
 * A flight booking is a specific type of booking that extends the base Booking class.
 * It inherits the unique identifier (id) and amount attributes from the base class.
 */
public class BookingFlight extends Booking {
    public BookingFlight(Integer id, Double amount) {
        super(id, amount);
    }
}