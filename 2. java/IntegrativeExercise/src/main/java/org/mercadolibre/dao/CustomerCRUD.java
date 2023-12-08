package org.mercadolibre.dao;

import org.mercadolibre.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of CRUD operations for managing Customer objects.
 */
public class CustomerCRUD implements CRUD<Customer> {
    private final List<Customer> client;

    /**
     * Constructs a new CustomerCRUD instance with an empty list of clients.
     */
    public CustomerCRUD() {
        this.client = new ArrayList<>();
    }

    /**
     * Creates a new customer in the data store.
     *
     * @param client The customer to be created.
     * @return The created customer if successful, null if the customer already exists.
     */
    public Customer create(Customer client) {
        boolean clientExists = this.client.stream()
                .anyMatch(existingClient -> existingClient.getDni().equals(client.getDni()));

        if (clientExists) {
            System.out.println("El cliente con el DNI " + client.getDni() + " ya existe.");
            return null;
        } else {
            this.client.add(client);
            return client;
        }
    }

    /**
     * Retrieves a customer from the data store based on their unique identifier (DNI).
     *
     * @param dni The unique identifier of the customer to be retrieved.
     * @return The retrieved customer, or null if not found.
     */
    public Customer read(String dni) {
        Optional<Customer> clientFound = client.stream()
                .filter(client -> client.getDni().equals(dni))
                .findFirst();

        return clientFound.orElse(null);
    }

    /**
     * Updates an existing customer in the data store.
     *
     * @param client The customer to be updated.
     * @return The updated customer if successful, or null if the customer to be updated is not found.
     */
    public Customer update(Customer client) {
        Customer current = read(client.getDni());
        if (current != null)
            current = client;
        return current;
    }

    /**
     * Deletes a customer from the data store based on their unique identifier (DNI).
     *
     * @param dni The unique identifier of the customer to be deleted.
     */
    public void delete(String dni) {
        client.removeIf(client -> client.getDni().equals(dni));
    }

    /**
     * Retrieves a list of all customers in the data store.
     *
     * @return A list containing all customers in the data store.
     */
    public List<Customer> getAll() {
        return client;
    }
}
