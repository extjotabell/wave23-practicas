package main;
import java.util.*;
public class Inscription {
    private long numberInscription;
    private Category category;
    private Competitor competitor;
    private double price;

    public Inscription(long numberInscription, Category category, Competitor competitor, double price) throws Exception {
        this.numberInscription = numberInscription;
        this.category = category;
        this.competitor = competitor;
        this.price = calculatePrice();
    }

    public double calculatePrice() throws Exception {
        double totalPrice=0;

        if(category.getId() == 1){
            if(competitor.getAge()<18){
                totalPrice = 1300;
            }else {
                totalPrice = 1500;
            }
        } else if(category.getId() == 2){
            if(competitor.getAge()<18){
                totalPrice = 2000;
            }else {
                totalPrice = 2300;
            }
        } else if(competitor.getAge()<18 && category.getId() == 3){
            throw new Exception("No se pueden inscribir menores a esta categoria.");
        } else{
            totalPrice = 2800;
        }
        return totalPrice;
    }

    public long getNumberInscription() {
        return numberInscription;
    }

    public void setNumberInscription(long numberInscription) {
        this.numberInscription = numberInscription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
