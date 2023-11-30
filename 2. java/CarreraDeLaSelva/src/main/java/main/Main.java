package main;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Map<Competitor,Inscription> map = new HashMap<>();
        Set<Category> categories = new HashSet<>();
        long idCategory;

        Category category1 = new Category(1,"Circuito Chico","2 km por selva y arroyos.");
        Category category2 = new Category(2,"Circuito Medio","5 km por selva, arroyos y barro.");
        Category category3 = new Category(3,"Circuito Avanzado","10 km por selva, arroyos, barro y escalada en piedra.");

        Competitor competitor1 = new Competitor(1,11111111,"Geronimo","Schmidt",24,"2611111111","2612222221","A+");
        Competitor competitor2 = new Competitor(2,11111112,"Alice","Schmidt",31,"2611111112","2612222222","O-");
        Competitor competitor3 = new Competitor(3,11111113,"John","Schmidt",27,"2611111113","2612222223","A+");
        Competitor competitor4 = new Competitor(4,11111114,"Steve","Schmidt",55,"2611111114","2612222224","A+");

        Inscription inscription1 = new Inscription(1,category1,competitor1,0);
        Inscription inscription2 = new Inscription(2,category2,competitor2,0);
        Inscription inscription3 = new Inscription(3,category3,competitor3,0);
        Inscription inscription4 = new Inscription(4,category1,competitor4,0);

        //add categories to set
        setCategories(categories, category1, category2, category3);
        //add competitors & inscriptions to map
        setMap(map, competitor1, competitor2, competitor3, competitor4, inscription1, inscription2, inscription3,inscription4);

        showAllCategories(map, categories);

        // Save id category before remove competitor
        idCategory = inscription1.getCategory().getId();
        removeCompetitor(map, competitor1);
        showCategoryAfterRemoveCompetitor(map, idCategory,categories);

        calculateTotalCollected(map);

    }

    private static void calculateTotalCollected(Map<Competitor, Inscription> map) {
        double totalMoneyCollectedCC=0;
        double totalMoneyCollectedCM=0;
        double totalMoneyCollectedCA=0;
        double totalAll=0;

        for(Map.Entry<Competitor,Inscription> entry : map.entrySet()){
            if(entry.getValue().getCategory().getId() == 1) {
                totalMoneyCollectedCC += entry.getValue().getPrice();
                totalAll += totalMoneyCollectedCC;
            }else if(entry.getValue().getCategory().getId() == 2){
                totalMoneyCollectedCM += entry.getValue().getPrice();
                totalAll+=totalMoneyCollectedCM;
            }else{
                totalMoneyCollectedCA += entry.getValue().getPrice();
                totalAll+=totalMoneyCollectedCA;
            }
        }

        System.out.println("---------------------------------------------------");
        System.out.println("INFORMACION FINAL DINERO");
        System.out.println("TOTAL CARRERA CHICA: "+totalMoneyCollectedCC);
        System.out.println("TOTAL CARRERA MEDIA: "+totalMoneyCollectedCM);
        System.out.println("TOTAL CARRERA AVANZADA: "+totalMoneyCollectedCA);
        System.out.println("TOTAL RECAUDADO EN TODAS LAS CARRERAS: "+totalAll);

    }
    private static void showAllCategories(Map<Competitor, Inscription> map, Set<Category> categories) {
        showMapCircuitoChico(map, categories);
        showMapCircuitoMedio(map, categories);
        showMapCircuitoAvanzado(map, categories);
    }

    private static void setCategories(Set<Category> categories, Category category1, Category category2, Category category3) {
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
    }

    private static void showCategoryAfterRemoveCompetitor(Map<Competitor, Inscription> map, long idCategory,Set<Category> categories) {
        System.out.println("---------------------------------------------------");
        System.out.println("                  AFTER REMOVE                   ");
        if(idCategory ==1){
            showMapCircuitoChico(map,categories);
        }else if(idCategory == 2){
            showMapCircuitoMedio(map,categories);
        }else {
            showMapCircuitoAvanzado(map,categories);
        }
    }

    private static void removeCompetitor(Map<Competitor, Inscription> map, Competitor competitor) {
        map.remove(competitor);
    }
    private static void showMapCircuitoChico(Map<Competitor, Inscription> map, Set<Category> categories) {
        double totalMoneyCollectedCC=0;

        for(Category cat: categories) {
            if(cat.getId() == 1){
                System.out.println("---------------------------------------------------");
                System.out.println(cat.getName());
                System.out.println(cat.getDescription());
            }
        }
        for(Map.Entry<Competitor,Inscription> entry : map.entrySet()){
           if(entry.getValue().getCategory().getId() == 1){
                entry.getKey().showInfo();
               totalMoneyCollectedCC += entry.getValue().getPrice();
            }
        }

        System.out.println("Dinero recolectado hasta el momento: " +totalMoneyCollectedCC);
    }
    private static void showMapCircuitoMedio(Map<Competitor, Inscription> map,Set<Category> categories) {
        double totalMoneyCollectedCM=0;
        for(Category cat: categories) {
            if(cat.getId() == 2){
                System.out.println("---------------------------------------------------");
                System.out.println(cat.getName());
                System.out.println(cat.getDescription());
            }
        }
        for(Map.Entry<Competitor,Inscription> entry : map.entrySet()){
            if(entry.getValue().getCategory().getId() == 2) {
                entry.getKey().showInfo();
                totalMoneyCollectedCM += entry.getValue().getPrice();
            }
        }
        System.out.println("Dinero recolectado hasta el momento:  " +totalMoneyCollectedCM);
    }
    private static void showMapCircuitoAvanzado(Map<Competitor, Inscription> map,Set<Category> categories) {
        double totalMoneyCollectedCA=0;
        for(Category cat: categories) {
            if(cat.getId() == 3){
                System.out.println("---------------------------------------------------");
                System.out.println(cat.getName());
                System.out.println(cat.getDescription());
            }
        }
        for(Map.Entry<Competitor,Inscription> entry : map.entrySet()){
            if(entry.getValue().getCategory().getId() == 3){
                entry.getKey().showInfo();
                totalMoneyCollectedCA += entry.getValue().getPrice();
            }
        }
        System.out.println("Dinero recolectado hasta el momento:  " +totalMoneyCollectedCA);
    }

    private static void setMap(Map<Competitor, Inscription> map, Competitor competitor1, Competitor competitor2, Competitor competitor3, Competitor competitor4,Inscription inscription1, Inscription inscription2, Inscription inscription3,Inscription inscription4) {

        map.put(competitor1, inscription1);
        map.put(competitor2, inscription2);
        map.put(competitor3, inscription3);
        map.put(competitor4, inscription1);

    }
}
