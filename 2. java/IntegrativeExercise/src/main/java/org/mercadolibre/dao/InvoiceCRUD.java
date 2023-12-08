package org.mercadolibre.dao;

import org.mercadolibre.entity.Invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Implementation of CRUD operations for managing Invoice objects.
 */
public class InvoiceCRUD implements CRUD<Invoice> {
    private final List<Invoice> invoice;

    /**
     * Constructs a new InvoiceCRUD instance with an empty list of invoices.
     */
    public InvoiceCRUD() {
        this.invoice = new ArrayList<>();
    }

    /**
     * Creates a new invoice in the data store.
     *
     * @param invoice The invoice to be created.
     * @return The created invoice.
     */
    public Invoice create(Invoice invoice) {
        this.invoice.add(invoice);
        return invoice;
    }

    /**
     * Retrieves an invoice from the data store based on its unique identifier.
     *
     * @param id The unique identifier of the invoice to be retrieved.
     * @return The retrieved invoice, or null if not found.
     */
    @Override
    public Invoice read(String id) {
        Optional<Invoice> invoiceFound = this.invoice.stream()
                .filter(inv -> Objects.equals(inv.getVoiceNro(), id))
                .findFirst();

        return invoiceFound.orElse(null);
    }

    /**
     * Updates an existing invoice in the data store.
     *
     * @param updatedInvoice The invoice to be updated.
     * @return The updated invoice if successful, or null if the invoice to be updated is not found.
     */
    @Override
    public Invoice update(Invoice updatedInvoice) {
        Invoice current = read(String.valueOf(updatedInvoice.getVoiceNro()));
        if (current != null)
            current = updatedInvoice;
        return current;
    }

    /**
     * Deletes an invoice from the data store based on its unique identifier.
     *
     * @param id The unique identifier of the invoice to be deleted.
     */
    @Override
    public void delete(String id) {
        this.invoice.removeIf(inv -> Objects.equals(inv.getVoiceNro(), id));
    }

    /**
     * Retrieves a list of all invoices in the data store.
     *
     * @return A list containing all invoices in the data store.
     */
    @Override
    public List<Invoice> getAll() {
        return this.invoice;
    }
}

