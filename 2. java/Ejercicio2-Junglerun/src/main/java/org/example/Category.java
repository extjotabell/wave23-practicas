package org.example;

import java.io.PrintStream;
import java.util.*;

public class Category {

    private int id;
    private String name;
    private String description;
    private HashSet<Inscription> inscriptions;

    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.inscriptions = new HashSet();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void inscription(Inscription inscription) {
        this.inscriptions.add(inscription);
    }

    public void unsuscribe(Inscription inscription) {
        this.inscriptions.remove(inscription);
    }

    public void getInscriptions() {
        System.out.println("Competidores de la categoría: " + this.name);
        Iterator var1 = this.inscriptions.iterator();

        while(var1.hasNext()) {
            Inscription inscription = (Inscription)var1.next();
            PrintStream var10000 = System.out;
            String var10001 = inscription.getCompetitor().getName();
            var10000.println("Competidor: " + var10001 + ". Inscripción número: " + inscription.getCompetitor().getId() + ". Costo total: " + inscription.getAmount());
        }

    }

    public double calculateTotalAmount() {
        return inscriptions.stream().mapToDouble(Inscription::getAmount).sum();
    }
}
