package org.example;

public class Inscription {

    private int id;
    private double amount;
    private Competitor competitor;
    private Category category;
    private static int nextID;

    public Inscription(Competitor competitor, Category category) {
        if (category.getName().equals("Circuito avanzado") && competitor.getAge() < 18) {
            throw new IllegalStateException("Participantes menores de 18 años no pueden participar en el circuito avanzado.");
        } else {
            this.id = ++nextID;
            this.competitor = competitor;
            this.category = category;
            this.amount = calcularMonto(competitor, category);
        }
    }

    private static double calcularMonto(Competitor par, Category cat) {
        double var10000;
        switch (cat.getName()) {
            case "Circuito chico":
                var10000 = par.getAge() < 18 ? 1300.0 : 1500.0;
                break;
            case "Circuito medio":
                var10000 = par.getAge() < 18 ? 2000.0 : 2300.0;
                break;
            case "Circuito avanzado":
                var10000 = 2800.0;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + cat.getName());
        }

        return var10000;
    }

    public double getAmount() {
        return this.amount;
    }

    public Competitor getCompetitor() {
        return this.competitor;
    }
}
