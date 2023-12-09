package repositories;

import models.CRUD;
import models.Customer;
import models.Invoice;

import java.util.List;

public class InvoiceRepository extends CRUD<Invoice> {
    public InvoiceRepository(List<Invoice> entities) {
        super(entities);
    }
}
