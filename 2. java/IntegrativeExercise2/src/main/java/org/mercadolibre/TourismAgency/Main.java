package org.mercadolibre.TourismAgency;

import org.mercadolibre.TourismAgency.model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(12345678, "Juan", "Perez");

        BookingComplete booking = new BookingComplete(1, 20000.0);
        List<Booking> bookings = List.of(booking);

        Locator locator = new Locator(bookings, customer);

        Repository repository = new Repository();

        repository.addLocator(locator);

        repository.listar();

        locator.printDetail();

    }
}