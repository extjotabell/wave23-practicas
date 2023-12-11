package org.mercadolibre.TourismAgency.entity;

import java.util.List;

/**
 * The Locator class represents a booking locator within the Tourism Agency system.
 * It implements the IPrintable interface to provide a standardized way of printing
 * detailed information about its state.
 */
public class Locator implements IPrintable {

    /** The list of bookings associated with the locator. */
    private List<Booking> bookings;
    /** The customer associated with the locator. */
    private Customer customer;
    /** The total amount for all bookings in the locator. */
    private Double amount;

    public Locator(List<Booking> bookings, Customer customer) {
        this.bookings = bookings;
        this.customer = customer;
        this.amount = totalAmount();
    }

    /**
     * Calculates the total amount for all bookings in the locator.
     *
     * @return The total amount for all bookings.
     */
    private Double totalAmount() {
        return bookings.stream().mapToDouble(Booking::getAmount).sum();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Prints detailed information about the locator, including its bookings, customer, and total amount.
     * This method implements the IPrintable interface.
     */
    @Override
    public void printDetail() {
        System.out.println("Locator");
        System.out.println("Bookings:");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
        System.out.println("Customer: " + customer.getName() + " " + customer.getLastname());
        System.out.println("Amount: " + amount);
    }
}