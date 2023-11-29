package org.example;

class Inscription {
    private int id;
    private double amount;
    private Competitor competitor;
    private Category category;
    private static int nextID;

    public Inscription(Competitor competitor, Category category) {
        try {
            if (category.getName().equals("Circuito avanzado") && competitor.getAge() < 18) {
                throw new InvalidAgeException("Participantes menores de 18 años no pueden participar en el circuito avanzado.");
            }
            this.id = ++nextID;
            this.competitor = competitor;
            this.category = category;
            this.amount = calculateAmount(competitor, category);
        } catch (InvalidAgeException e) {
            System.out.println("Términos y condiciones: " + e.getMessage());
        }
    }

    private static double calculateAmount(Competitor competitor, Category category) {
        return switch (category.getName()) {
            case "Circuito chico" -> (competitor.getAge() < 18) ? 1300 : 1500;
            case "Circuito medio" -> (competitor.getAge() < 18) ? 2000 : 2300;
            case "Circuito avanzado" -> 2800;
            default -> throw new IllegalStateException("Unexpected value: " + category.getName());
        };
    }

    public double getAmount() {
        return amount;
    }

    public Competitor getCompetitor() {
        return competitor;
    }
}