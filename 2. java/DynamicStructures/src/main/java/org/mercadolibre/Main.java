package org.mercadolibre;

import org.mercadolibre.model.*;

public class Main {
    public static void main(String[] args) {
        Category category1 = new Category(1, "Circuito chico", "2 km por selva y arroyos");
        Category category2 = new Category(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Category category3 = new Category(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        Competitor competitor1 = new Competitor(1, "Juan", 21);
        Competitor competitor2 = new Competitor(2, "Pedro", 30);
        Competitor competitor3 = new Competitor(3, "Carlos", 16);
        Competitor competitor4 = new Competitor(4, "Ana", 25);
        Competitor competitor5 = new Competitor(5, "Luisa", 19);

        Inscription inscription1 = new Inscription(competitor1, category1);
        Inscription inscription2 = new Inscription(competitor2, category1);
        Inscription inscription3 = new Inscription(competitor3, category3);
        Inscription inscription4 = new Inscription(competitor2, category2);
        Inscription inscription5 = new Inscription(competitor4, category3);
        Inscription inscription6 = new Inscription(competitor5, category2);

        category1.inscription(inscription1);
        category2.inscription(inscription4);
        category3.inscription(inscription3);
        category1.inscription(inscription2);
        category3.inscription(inscription5);
        category2.inscription(inscription6);

        System.out.println("Competidores inscritos en Circuito chico:");
        category1.getInscriptions();
        System.out.println("\nCompetidores inscritos en Circuito medio:");
        category2.getInscriptions();
        System.out.println("\nCompetidores inscritos en Circuito avanzado:");
        category3.getInscriptions();

        System.out.println("\nMonto total recaudado por Circuito chico: $" + category1.calculateTotalAmount());
        System.out.println("Monto total recaudado por Circuito medio: $" + category2.calculateTotalAmount());
        System.out.println("Monto total recaudado por Circuito avanzado: $" + category3.calculateTotalAmount());
    }
}