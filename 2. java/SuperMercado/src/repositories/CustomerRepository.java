package repositories;

import models.CRUD;
import models.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerRepository extends CRUD<Customer> {
    public CustomerRepository(List<Customer> customers) {
        super(customers);
    }

    public Optional<Customer> consultDNI(int dni) {
        return consult().stream().
                filter(x -> x.getDni() == dni)
                .findFirst();
    }
}
