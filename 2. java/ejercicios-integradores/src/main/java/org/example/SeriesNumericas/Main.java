package org.example.SeriesNumericas;

public class Main {
    public static void main(String[] args) {
        Subprototipo1 subprototipo1 = new Subprototipo1(2.0, 0.0);
        System.out.println(subprototipo1.nextValue());
        System.out.println(subprototipo1.nextValue());
        System.out.println(subprototipo1.nextValue());
        System.out.println(subprototipo1.nextValue());

        System.out.println("-----------------------");
        Subprototipo2 subprototipo2 = new Subprototipo2(2, 1);
        System.out.println(subprototipo2.nextValue());
        System.out.println(subprototipo2.nextValue());
        System.out.println(subprototipo2.nextValue());
        System.out.println(subprototipo2.nextValue());

        System.out.println("-----------------------");
        Subprototipo2 subprototipo3 = new Subprototipo2(3, 0);
        System.out.println(subprototipo3.nextValue());
        System.out.println(subprototipo3.nextValue());
        System.out.println(subprototipo3.nextValue());
        System.out.println(subprototipo3.nextValue());
    }
}
