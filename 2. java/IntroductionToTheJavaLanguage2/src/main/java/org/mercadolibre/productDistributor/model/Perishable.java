package org.mercadolibre.productDistributor.model;

public class Perishable extends Product {
    private int daysToExpire;

    public Perishable(int daysToExpire, String name, double price) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public double calculator(int candidateProductions){
        double actualPrice = price * candidateProductions;

        switch (daysToExpire){
            case 1->{actualPrice = actualPrice/4;}
            case 2->{actualPrice = actualPrice/3;}
            case 3->{actualPrice = actualPrice/2;}
        }
        return actualPrice;
    }

    @Override
    public String toString() {
        return "Alimento perecedero con " + daysToExpire +  " días para la fecha de vencimiento.\n";
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }
}
