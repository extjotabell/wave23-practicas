package com.caloriescalc.practice.request;

public class RequestDish {
    private String name;
    private int weigth;

    public RequestDish() {
    }

    public RequestDish(String name, int weigth) {
        this.name = name;
        this.weigth = weigth;
    }

    public String getName() {
        return name;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    @Override
    public String toString() {
        return "RequestDish{" +
                "name='" + name + '\'' +
                ", weigth=" + weigth +
                '}';
    }
}
