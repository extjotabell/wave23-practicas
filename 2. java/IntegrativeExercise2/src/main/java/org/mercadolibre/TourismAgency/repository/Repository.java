package org.mercadolibre.TourismAgency.repository;

import org.mercadolibre.TourismAgency.entity.Locator;

import java.util.ArrayList;
import java.util.List;

/**
 * The Repository class manages the storage and retrieval of Locator objects in the Tourism Agency system.
 * It provides various methods for manipulating and retrieving information about locators and their bookings.
 */
public class Repository {

    /** The list of locators stored in the repository. */
    private final List<Locator> locatorList = new ArrayList<>();

    /**
     * Adds a new locator to the repository.
     *
     * @param locator The Locator object to be added to the repository.
     */
    public void addLocator(Locator locator) {
        locatorList.add(locator);
    }

    /**
     * Lists the details of all locators stored in the repository.
     * Uses the printDetail method of the Locator class to display detailed information.
     */
    public void listLocators() {
        locatorList.forEach(Locator::printDetail);
    }

    /**
     * Retrieves the total number of locators stored in the repository.
     *
     * @return The total number of locators.
     */
    public int getNumberOfLocators() {
        return locatorList.size();
    }

    /**
     * Retrieves the total number of bookings across all locators in the repository.
     *
     * @return The total number of bookings.
     */
    public int getTotalBookings() {
        return locatorList.stream().mapToInt(locator -> locator.getBookings().size()).sum();
    }

    /**
     * Retrieves the total sales amount across all locators in the repository.
     *
     * @return The total sales amount.
     */
    public double getTotalSales() {
        return locatorList.stream().mapToDouble(Locator::getAmount).sum();
    }

    /**
     * Retrieves the average sales amount per locator in the repository.
     *
     * @return The average sales amount.
     */
    public double getAverageSales() {
        return getTotalSales() / getNumberOfLocators();
    }

    /**
     * Lists the type of each booking across all locators stored in the repository.
     * Uses the class's simple name to display the booking type.
     */
    public void listBookingsByType() {
        locatorList.stream()
                .flatMap(locator -> locator.getBookings().stream())
                .forEach(booking -> System.out.println("Tipo de reserva: " + booking.getClass().getSimpleName()));
    }
}