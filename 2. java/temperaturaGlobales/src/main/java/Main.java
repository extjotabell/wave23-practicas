public class Main {
    public static void main(String[] args) {
        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        final int ZERO = 0;
        final int ONE = 1;
        int minimumTemperature = temperatures[ZERO][ZERO];
        int maximunTemperature = temperatures[ZERO][ONE];
        int cityMinimunIndex = ZERO;
        int cityMaximunIndex = ZERO;

        for (int i = 1; i < cities.length; i++) {
            int currentMinimunTemperature = temperatures[i][ZERO];
            int currentMaximunTemperature = temperatures[i][ONE];

            if (currentMinimunTemperature < minimumTemperature){
                minimumTemperature = currentMinimunTemperature;
                cityMinimunIndex = i;
            }
            if (currentMaximunTemperature > maximunTemperature){
                maximunTemperature = currentMaximunTemperature;
                cityMaximunIndex = i;
            }
        }

        System.out.println("La ciudad con menor temperatura es " + cities[cityMinimunIndex] + " con " + minimumTemperature + " ºC.");
        System.out.println("La ciudad con mayor temperatura es " + cities[cityMaximunIndex] + " con " + maximunTemperature + " ºC.");
    }
}