import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static  HashMap<Competitor, Inscription> inscriptions = new HashMap<>();

    public static void main(String[] args) {
        LinkedList<Category> categories = new LinkedList<>();
        Category category_small = new Category(1, "Circuito chico", "2 km por selva y arroyos");
        Category category_medium = new Category(2, "Circuito medio", "5 km por selva, arroyos y barro.");
        Category category_big = new Category(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        categories.add(category_small);
        categories.add(category_medium);
        categories.add(category_big);

        // Test Data Competitors
        Competitor competitorOne = new Competitor(
                1, 12345678, "Matias", "Fiermarin", 31,
                "4567890", "92837474", "O+");
        Competitor competitorTwo = new Competitor(
                2, 96372832, "Ramon", "Lopez", 17,
                "8923498", "90569348", "B");
        Competitor competitorThree = new Competitor(
                3, 64539284, "Laura", "Gonzelez", 27,
                "0192380", "823782732", "A+");
        Competitor competitorFour = new Competitor(
                4, 98234890, "Maria", "Perez", 17,
                "9823121", "678328732", "A+");

        addCompetitor(competitorOne, category_small);
        addCompetitor(competitorTwo, category_medium);
        addCompetitor(competitorThree, category_big);
        addCompetitor(competitorFour, category_big);

        System.out.println("El participante " + competitorOne.getFirstName() + " " +
                competitorOne.getLastName() + " se inscribio en la categoria "+ category_small.getName()
                + " y el costo es de " + inscriptions.get(competitorOne).getAmmount()
        );

        System.out.println("Listado de inscriptos a una categoria");
        inscriptionsByCategory(category_small);

        System.out.println("Elimiando participante");
        removeCompetitor(competitorOne);
        inscriptionsByCategory(category_small);

        System.out.println("Total recudado por categoria");
        totalAmountByCategory();

        System.out.println("Total recaudado para todas las categorias");
        totalAmountForAllCateogry();
    }

    public static void addCompetitor(Competitor competitor, Category category){
        try{
            if(inscriptions.containsKey(competitor)){
                System.out.println("Competidor ya inscrito en una categoria.");
            }

            Inscription inscription = new Inscription(competitor, category);

            inscriptions.put(competitor, inscription);
            System.out.println("Competidor inscripto correctamente");
        }catch (IllegalStateException e){
            System.out.println("Hubo un problema al inscribir al participante " + competitor.getFirstName() +
                    " " + competitor.getLastName() +". "+ e.getMessage());
        }
    }

    public static void removeCompetitor(Competitor competitor) {
        try {
            if (!inscriptions.containsKey(competitor)) {
                System.out.println("El competidor no esta en ninguna categoria.");
            }

            inscriptions.remove(competitor);
            System.out.println("Participante desinscripto");
        }catch (Exception e){
            System.out.println("Hubo un problema al eliminar el participante " + competitor.getFirstName() + competitor.getLastName());
        }
    }

    public static void inscriptionsByCategory(Category category){
        for (Inscription inscription : inscriptions.values()){
            if(inscription.getCategory().equals(category)) {
                System.out.println(inscription.getCompetitor().toString());
                System.out.println("Id de la inscripcion: " + inscription.getId());
            }
        }
    }

    public static void totalAmountByCategory() {
        Map<Category, Double> totalAmount = new HashMap<>();

        for(Inscription inscription : inscriptions.values()){
            if(!totalAmount.containsKey(inscription.getCategory())) {
                totalAmount.put(inscription.getCategory(), inscription.getAmmount());
            }else {
                double partialAmount = totalAmount.get(inscription.getCategory());
                totalAmount.put(inscription.getCategory(), partialAmount + inscription.getAmmount());
            }
        }

        for (Map.Entry<Category, Double> entry : totalAmount.entrySet()){
            Category category = entry.getKey();
            Double total = entry.getValue();
            System.out.println("Lo recaudado para la categoria "+ category.getName() + " fue de $" + total);
        }
    }

    public static void totalAmountForAllCateogry() {
        double total = 0;

        for(Inscription inscription : inscriptions.values()){
            total += inscription.getAmmount();
        }

        System.out.println("Lo total recaudado fue de $" + total);
    }
}