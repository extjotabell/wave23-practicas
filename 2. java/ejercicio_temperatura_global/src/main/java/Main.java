public class Main {
    public static void main(String[] args) {
        final String[] cities = new String[]{
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

        final int[][] temperatures = {
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

        final int numCities = cities.length;
        int maxTemp = Integer.MIN_VALUE;
        int maxTempCityIndex = 0;
        int minTemp = Integer.MAX_VALUE;
        int minTempCityIndex = 0;

        for (int i = 0; i < numCities; i++) {
            if (maxTemp <= temperatures[i][1]) {
                maxTemp = temperatures[i][1];
                maxTempCityIndex = i;
            }
            if (minTemp >= temperatures[i][0]) {
                minTemp = temperatures[i][0];
                minTempCityIndex = i;
            }
        }

        System.out.println("City with max temp: " + cities[maxTempCityIndex] + ", temp: " + maxTemp);
        System.out.println("City with min temp: " + cities[minTempCityIndex] + ", temp: " + minTemp);

    }
}