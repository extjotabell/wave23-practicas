public class Main {

    static int[] minMax(int matrix[][], boolean max) {
        int value = matrix[0][0];
        int valueRow = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if ((max && matrix[row][col] > value) || (!max && matrix[row][col] < value)) {
                    value = matrix[row][col];
                    valueRow = row;
                }
            }
        }

        return new int[]{value, valueRow};
    }

    public static void main(String[] args) {
        String cities[] = new String[]{
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

        int temperatures[][] = new int[][]{
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

        int[] max_info = minMax(temperatures, true);
        int[] min_info = minMax(temperatures, false);

        System.out.println("Temperatura máxima: " + max_info[0] + "°C en " + cities[max_info[1]]);
        System.out.println("Temperatura mínima: " + min_info[0] + "°C en " + cities[min_info[1]]);
    }
}
