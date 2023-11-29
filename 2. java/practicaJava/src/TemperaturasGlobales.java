public class TemperaturasGlobales {

    public static void main(String[] args) {
        String[] ciudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asuncion",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        double[][] temperaturas={
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35}
        };

        int indexMinT = 0;
        int indexMaxT=1;

        String ciudadMinT = ciudades[0];
        String ciudadMaxT = ciudades[0];
        double minT =  temperaturas[0][indexMinT];
        double maxT =  temperaturas[0][indexMaxT];

        for (int i = 1; i<temperaturas.length;i++){
            double temperaturaMin= temperaturas[i][indexMinT];
            double temperaturaMax= temperaturas[i][indexMaxT];
            if(temperaturaMin<minT){
                minT = temperaturaMin;
                ciudadMinT=ciudades[i];
            }
            if(temperaturaMax>maxT){
                maxT = temperaturaMax;
                ciudadMaxT=ciudades[i];
            }
        }

        System.out.println("La ciudad con la minima temperatura entre todas las ciudades fue "+
                ciudadMinT + " con una temperatura minima registrada de " +
                minT +" grados celcius");
        System.out.println("La ciudad con la maxima temperatura entre todas las ciudades fue "+
                ciudadMaxT + " con una temperatura maxima registrada de " +
                maxT+" grados celcius");

    }
}
