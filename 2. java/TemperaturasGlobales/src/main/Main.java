package main;

public class Main {
    public static void main(String[] args) {
        String[] cities = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int[][] temperatures = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        int indexMin = 0;
        int indexMax = 0;
        int tempMin = 0;
        int tempMax = 0;

        for (int i = 0; i < temperatures.length; i++) {
            if(temperatures[i][0] < tempMin){
                tempMin = temperatures[i][0];
                indexMin = i;
            }

            if(temperatures[i][1] > tempMax){
                tempMax = temperatures[i][1];
                indexMax = i;
            }
        }

        System.out.println("La mayor temperatura fue en la ciudad de " + cities[indexMax] + " y es de " + tempMax);
        System.out.println("la menor  temperatura la tuvo la ciudad de "+ cities[indexMin] + " y es " + tempMin);

    }
}
