package org.example;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Supermarket {
    private Set<Client> clients;
    private ArrayList<Expense> expenses;

    public Supermarket() {
        this.clients = new TreeSet<>(new Client());
        this.expenses = new ArrayList<>();
    }

    public Supermarket(Set<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void deleteClient(Client tomasv) {
        this.clients.remove(tomasv);
        this.clients.forEach(System.out::println);
    }

    public void searchClientByDNI(Integer DNI) {
        this.clients.forEach(element -> {
            if (element.getDNI().equals(DNI)) {
                System.out.println(element);
            }
        });
    }

    public void getClients() {
        this.clients.forEach(System.out::println);
    }

    public void generateExpense(Client person, List<Product> products) throws NotClientException {
        if (isPersonNotCLient(person.getDNI())) {
            throw new NotClientException("La persona no es cliente");
        }
        Double total = getTotalExpense(products);
        Expense expense = new Expense(person, products, total);
        this.expenses.add(expense);
    }

    private static Double getTotalExpense(List<Product> products) {
        return products.stream()
                .mapToDouble(value -> value.getPurchasedAmount() * value.getUnitCost()).sum();
    }

    private boolean isPersonNotCLient(Integer dni) {
        return this.clients.stream().noneMatch(client -> client.getDNI().equals(dni));
    }

    public void getAllExpenses() {
        this.expenses.forEach(System.out::println);
    }
}
