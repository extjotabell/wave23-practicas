package org.example;

public class Main {
    public static void main(String[] args) {
        Supermarket chinoLuna = new Supermarket();
        Client tomasv = new Client(43735806, "Tomas", "Vazquez");
        chinoLuna.addClient(tomasv);
        chinoLuna.addClient(new Client(43735807, "Sofia", "Vega"));
        chinoLuna.addClient(new Client(43735808, "Miley", "Cyrus"));

        System.out.println("------ getClients -----");
        chinoLuna.getClients();

        System.out.println("------ deleteClient -----");
        chinoLuna.deleteClient(tomasv);

        System.out.println("----- searchClient -----");
        chinoLuna.searchClientByDNI(43735807);
    }
}