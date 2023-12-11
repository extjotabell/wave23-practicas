package org.mercadolibre.TourismAgency;

import org.mercadolibre.TourismAgency.entity.*;
import org.mercadolibre.TourismAgency.repository.*;

import java.util.List;

/**
 * The Main class represents the entry point of the Tourism Agency application.
 * It demonstrates various scenarios involving the creation of locators, applying discounts, and printing details.
 */
public class Main {
    /**
     * The main method executes the demonstration scenarios for the Tourism Agency application.
     *
     * @param args The command line arguments (not used in this application).
     */
    public static void main(String[] args) {

        Customer customer = new Customer(12345678, "Juan", "Perez");

        BookingComplete bookingComplete = new BookingComplete(1, 20000.0);
        List<Booking> bookingsComplete = List.of(bookingComplete);

        Locator locatorComplete = new Locator(bookingsComplete, customer);

        Repository repository = new Repository();
        repository.addLocator(locatorComplete);

        System.out.println("Scenario 1:");
        repository.listLocators();
        System.out.println();

        BookingHotel bookingHotel = new BookingHotel(2, 5000.0);
        BookingFlight bookingFlight = new BookingFlight(3, 8000.0);

        List<Booking> bookingsMixed = List.of(bookingHotel, bookingFlight);

        Locator locatorMixed = new Locator(bookingsMixed, customer);
        repository.addLocator(locatorMixed);

        System.out.println("Escenario 2:");
        repository.listLocators();
        System.out.println();

        BookingHotel bookingHotel2 = new BookingHotel(4, 7000.0);

        List<Booking> bookingsSingle = List.of(bookingHotel2);

        Locator locatorSingle = new Locator(bookingsSingle, customer);
        repository.addLocator(locatorSingle);

        System.out.println("Escenario 3:");
        repository.listLocators();
        System.out.println();

        System.out.println("Descuentos aplicados en el Escenario 2:");
        applyDiscounts(locatorMixed);
        locatorMixed.printDetail();
    }

    /**
     * Applies discounts to a given locator based on predefined conditions.
     *
     * @param locator The Locator object to which discounts will be applied.
     */
    private static void applyDiscounts(Locator locator) {
        if (locator.getBookings().size() >= 2) {
            System.out.println("Se aplica un descuento del 5% por tener al menos 2 reservas.");
            locator.setAmount(locator.getAmount() * 0.95);
        }

        if (locator.getBookings().size() == 4) {
            System.out.println("Se aplica un descuento del 10% por tener un paquete completo con 4 reservas.");
            locator.setAmount(locator.getAmount() * 0.9);
        }

        long hotelCount = locator.getBookings().stream().filter(booking -> booking instanceof BookingHotel).count();
        long flightCount = locator.getBookings().stream().filter(booking -> booking instanceof BookingFlight).count();

        if (hotelCount == 2 || flightCount == 2) {
            System.out.println("Se aplica un descuento del 5% por tener 2 reservas del mismo tipo (hotel o vuelo).");
            locator.setAmount(locator.getAmount() * 0.95);
        }
    }
}