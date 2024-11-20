import java.util.Random;

public class Main3 {

    public static void main(String[] args) {
        // Определяем размеры матрицы
        int rows = 5; // Количество строк
        int cols = 6; // Количество столбцов

        // Создаем и заполняем матрицу случайными значениями
        int[][] matrix = generateRandomMatrix(rows, cols, -50, 50);

        // Выводим матрицу
        printMatrix(matrix, "Сгенерированная матрица:");

        // Строим вектор B
        int[] positiveCountVector = countPositiveElementsInColumns(matrix);

        // Выводим вектор B
        printVector(positiveCountVector, "Вектор B (количество положительных элементов в каждом столбце):");
    }

    // Метод для генерации двумерной матрицы случайных чисел
    public static int[][] generateRandomMatrix(int rows, int cols, int minValue, int maxValue) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(maxValue - minValue + 1) + minValue;
            }
        }
        return matrix;
    }

    // Метод для подсчета положительных элементов в каждом столбце матрицы
    public static int[] countPositiveElementsInColumns(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] positiveCount = new int[cols];

        for (int j = 0; j < cols; j++) { // По столбцам
            for (int i = 0; i < rows; i++) { // По строкам
                if (matrix[i][j] > 0) {
                    positiveCount[j]++;
                }
            }
        }
        return positiveCount;
    }

    // Метод для вывода матрицы
    public static void printMatrix(int[][] matrix, String message) {
        System.out.println(message);
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d ", value);
            }
            System.out.println();
        }
    }

    // Метод для вывода вектора
    public static void printVector(int[] vector, String message) {
        System.out.println(message);
        for (int value : vector) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
