package main;

public class Main {
    public static void main(String[] args) {
        String cities[] = new String [10];
        int temperatures[][] = new int[10][2];
        int higher = temperatures[0][1];
        int lower = temperatures[0][0];
        int indexHigher = 0;
        int indexLower = 0;

        //Carga vector cuidades
        setCities(cities);

        //Carga matriz temperaturas
        setTemperatures(temperatures);

        //Obtener mayor y menor temperatura
        getLowerAndHigher(cities, temperatures, higher, lower, indexHigher, indexLower);
    }

    private static void getLowerAndHigher(String[] cities, int[][] temperatures, int higher, int lower, int indexHigher, int indexLower) {
        for(int i = 0; i<10;i++){
            if(temperatures[i][1] > higher){
                higher = temperatures[i][1];
                indexHigher = i;
            }
            if(temperatures[i][0] < lower){
                lower = temperatures[i][0];
                indexLower = i;
            }
        }
        System.out.println("La mayor temperatura es: " + higher + "C, de la cuidad " + cities[indexHigher] +".");
        System.out.println("La menor temperatura es: " + lower + "C, de la cuidad " + cities[indexLower]+".");
    }

    private static void setTemperatures(int[][] temperatures) {
        temperatures[0][0] = -2;
        temperatures[0][1] = 33;
        temperatures[1][0] = -3;
        temperatures[1][1] = 32;
        temperatures[2][0] = -8;
        temperatures[2][1] = 27;
        temperatures[3][0] = 4;
        temperatures[3][1] = 37;
        temperatures[4][0] = 6;
        temperatures[4][1] = 42;
        temperatures[5][0] = 5;
        temperatures[5][1] = 43;
        temperatures[6][0] = 0;
        temperatures[6][1] = 39;
        temperatures[7][0] = -7;
        temperatures[7][1] = 26;
        temperatures[8][0] = -1;
        temperatures[8][1] = 31;
        temperatures[9][0] = -10;
        temperatures[9][1] = 35;
    }

    private static void setCities(String[] cities) {
        cities[0] = "Londres";
        cities[1] = "Madrid";
        cities[2] = "Nueva York";
        cities[3] = "Buenos Aires";
        cities[4] = "Asuncion";
        cities[5] = "Sao Paulo";
        cities[6] = "Lima";
        cities[7] = "Santiago de Chile";
        cities[8] = "Lisboa";
        cities[9] = "Tokio";
    }
}

