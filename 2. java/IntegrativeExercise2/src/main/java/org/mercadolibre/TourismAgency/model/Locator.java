package org.mercadolibre.TourismAgency.model;

import java.util.List;

public class Locator implements IPrintable{
    private List<Booking> bookings;
    private Customer customer;

    private Double amount;

    public Locator() {
    }

    public Locator(List<Booking> bookings, Customer customer) {
        this.bookings = bookings;
        this.customer = customer;
        this.amount = totalAmount();
    }

    private Double totalAmount(){
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

    @Override
    public void printDetail() {
        System.out.println("Locator{" +
                "bookings=" + bookings +
                ", customer=" + customer +
                ", amount=" + amount +
                '}');
    }

}
