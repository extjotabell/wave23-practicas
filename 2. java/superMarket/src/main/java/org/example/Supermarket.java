package org.example;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Supermarket {
    private Set<Client> clients;

    public Supermarket() {
        this.clients = new TreeSet<>(new Client());
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
}
