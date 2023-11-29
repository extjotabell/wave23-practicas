public class Main {
    public static void main(String[] args) {
        String cities[] = {
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

        int temperatures[][] = {
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

        int numCities = cities.length;
        int maxTemp = temperatures[0][1];
        int maxIndexCity = 0;
        int minTemp = temperatures[0][0];
        int minIndexCity = 0;

        for (int i = 0; i < numCities; i++) {
            if (maxTemp <= temperatures[i][1]) {
                maxTemp = temperatures[i][1];
                maxIndexCity = i;
            }
            if (minTemp >= temperatures[i][0]) {
                minTemp = temperatures[i][0];
                minIndexCity = i;
            }
        }

        System.out.println("Max: " + cities[maxIndexCity] + " temp: " + maxTemp);
        System.out.println("Min: " + cities[minIndexCity] + " temp: " + minTemp);

    }
}