package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int n = 10;

        for(int i = 0; i < n; i++){
            for (int s = i; s <= n-1; s++){
                System.out.print(" ");
            }
            for(int j = 0; j <= i; j++){
                System.out.print("#");
            }
            System.out.println();
        }

    }

}