package org.mercadolibre;

public class TemperatureGlobal {
    public static void main(String[] args) {

        String[] cityNames = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatureData = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int maxTemperature = temperatureData[0][1];
        int minTemperature = temperatureData[0][0];

        int indexMinTemperature = 0;
        int indexMaxTemperature = 0;

        for (int i = 0; i < cityNames.length; i++) {
            int currentMinTemperature = temperatureData[i][0];
            int currentMaxTemperature = temperatureData[i][1];

            if (currentMinTemperature <= minTemperature) {
                minTemperature = currentMinTemperature;
                indexMinTemperature = i;
            }

            if (currentMaxTemperature >= maxTemperature) {
                maxTemperature = currentMaxTemperature;
                indexMaxTemperature = i;
            }
        }

        System.out.println("La mayor temperatura la tuvo " + cityNames[indexMaxTemperature] + " y es de " + maxTemperature + "º ");
        System.out.println("La menor temperatura la tuvo " + cityNames[indexMinTemperature] + " y es de " + minTemperature + "º ");
    }
}