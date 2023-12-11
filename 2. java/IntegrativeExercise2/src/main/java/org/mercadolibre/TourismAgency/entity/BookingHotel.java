package org.mercadolibre.TourismAgency.entity;

/**
 * Represents a hotel booking within the Tourism Agency system.
 * A hotel booking is a specific type of booking that extends the base Booking class.
 * It inherits the unique identifier (id) and amount attributes from the base class.
 */
public class BookingHotel extends Booking {
    public BookingHotel(Integer id, Double amount) {
        super(id, amount);
    }
}