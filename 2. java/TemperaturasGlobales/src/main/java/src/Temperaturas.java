package src;

public class Temperaturas {
    public static void main(String[] args) {

        String [] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int [][] temperatura = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43},
                {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int temperaturaMaxima = Integer.MIN_VALUE;
        int temperaturaMinima = Integer.MAX_VALUE;
        String ciudadTempMaxima = "";
        String ciudadTempMinima = "";

        for (int i = 0; i < ciudades.length; i++) {

            if (temperatura[i][1] > temperaturaMaxima) {
                temperaturaMaxima = temperatura[i][1];
                ciudadTempMaxima = ciudades[i];
            }

            if (temperatura[i][0] < temperaturaMinima) {
                temperaturaMinima = temperatura[i][0];
                ciudadTempMinima = ciudades[i];
            }
        }

        // Se muestra la temperatura máxima y mínima junto con sus ciudades
        System.out.println("La temperatura máxima registrada fue de " + temperaturaMaxima + " ºC en " + ciudadTempMaxima);
        System.out.println("La temperatura mínima registrada fue de " + temperaturaMinima + " ºC en " + ciudadTempMinima);
    }
}
