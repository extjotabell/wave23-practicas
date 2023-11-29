package org.example;
import java.util.ArrayList;
import java.util.List;

class Category {
    private final int id;
    private final String name;
    private final String description;
    private final List<Inscription> inscriptions;

    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.inscriptions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void inscription(Inscription inscription) {
        inscriptions.add(inscription);
    }

    public void unsuscribe(Inscription inscription) {
        inscriptions.remove(inscription);
    }

    public void getInscriptions() {
        inscriptions.forEach(this::printInscriptionDetails);
    }

    private void printInscriptionDetails(Inscription inscription) {
        Competitor competitor = inscription.getCompetitor();
        String message = (competitor != null)
                ? String.format("Competidor: %s. Inscripción número: %d. Costo total: %.2f",
                competitor.getName(), competitor.getId(), inscription.getAmount())
                : "Error: No se pudo inscribir al competidor. Favor revisar los términos y condiciones.";
        System.out.println(message);
    }

    public double calculateTotalAmount() {
        return inscriptions.stream().mapToDouble(Inscription::getAmount).sum();
    }
}