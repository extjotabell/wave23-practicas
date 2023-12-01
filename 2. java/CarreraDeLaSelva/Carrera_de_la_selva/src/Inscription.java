public class Inscription {
    private int id;
    private double ammount;
    private Competitor competitor;
    private Category category;
    private static int nextInt;

    public Inscription(Competitor competitor, Category category) {
        if (category.getName().equals("Circuito avanzado") && competitor.getAge() < 18) {
            throw new IllegalStateException("Participantes menores de 18 años no pueden participar en el circuito avanzado.");
        }

        this.id = nextInt++;
        this.ammount = calculateAmmount(competitor, category);
        this.competitor = competitor;
        this.category = category;
    }

    private double calculateAmmount(Competitor competitor, Category category) {
        if(category.getName().equals("Circuito chico")){
            return (competitor.getAge() < 18) ? 1300 : 1500;
        }else if(category.getName().equals("Circuito medio")) {
            return (competitor.getAge() < 18) ?  2000 : 2300;
        }else {
            return (competitor.getAge() > 18) ? 2800 : 0;
        }
    }

    public int getId() {
        return id;
    }

    public double getAmmount() {
        return ammount;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public Category getCategory() {
        return category;
    }
}
