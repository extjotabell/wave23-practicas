public class Main {
    public static void main(String[] args) {
        System.out.println("Hola mundo");
        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo",
                           "Lima", "Santiago de Chile", "Lisboa", "Tokyo" };

        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42},
                               {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int minTemperature = temperatures[0][0];
        int maxTemperature = temperatures[0][1];

        String minTemperatureCity = cities[0];
        String maxTemperatureCity = cities[0];

        for(int i = 0; i < cities.length; i++ ){
            if(temperatures[i][0] < minTemperature){
                minTemperature = temperatures[i][0];
                minTemperatureCity = cities[i];
            }

            if(temperatures[i][1] > maxTemperature){
                maxTemperature = temperatures[i][1];
                maxTemperatureCity = cities[i];
            }
        }

        System.out.printf("Min temperature: %s, %d%n", minTemperatureCity, minTemperature);
        System.out.printf("Max temperature: %s, %d%n", maxTemperatureCity, maxTemperature);
    }
}
