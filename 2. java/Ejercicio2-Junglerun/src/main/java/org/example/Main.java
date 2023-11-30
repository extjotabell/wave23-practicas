package org.example;

public class Main {
    public static void main(String[] args) {

        Category category1 = new Category(1, "Circuito chico", "2 km por selva y arroyos");
        Category category2 = new Category(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Category category3 = new Category(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        Competitor competitor1 = new Competitor(1, "Juan", 21);
        Competitor competitor2 = new Competitor(2, "Pedro", 30);
        Competitor competitor3 = new Competitor(3, "Carlos", 36);

        Inscription inscription1 = new Inscription(competitor1, category1);
        Inscription inscription2 = new Inscription(competitor2, category1);
        Inscription inscription3 = new Inscription(competitor3, category3);
        Inscription inscription4 = new Inscription(competitor2, category2);

        category1.inscription(inscription1);
        category2.inscription(inscription4);
        category3.inscription(inscription3);
        category1.inscription(inscription2);


        category1.getInscriptions();
        category2.getInscriptions();
        category3.getInscriptions();

    }
}