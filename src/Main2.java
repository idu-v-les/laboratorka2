import java.util.Arrays;
import java.util.Random;

public class Main2 {

    public static void main(String[] args) {
        // Заполняем массив случайными числами
        int[] b = fillRandomIntVector(30, 100, 200);

        // Вывод исходного массива
        printVector(b, "Исходный массив:");

        // Сжатие массива: корни квадратные из положительных элементов делённые на 5
        double[] c = compressAndTransformArray(b);
        printVector(c, "Сжатый массив (корни квадратные из положительных элементов, деленные на 5):");

        // Сортировка методом выбора
        selectionSort(c);
        printVector(c, "Сжатый массив после сортировки методом выбора:");
    }

    // Метод для заполнения массива случайными числами
    public static int[] fillRandomIntVector(int size, int minValue, int maxValue) {
        Random random = new Random();
        int[] vector = new int[size];
        for (int i = 0; i < size; i++) {
            vector[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }
        return vector;
    }

    // Метод для вывода массива целых чисел с сообщением
    public static void printVector(int[] vector, String message) {
        System.out.println(message);
        for (int value : vector) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Перегрузка метода для вывода массива с плавающей точкой
    public static void printVector(double[] vector, String message) {
        System.out.println(message);
        for (double value : vector) {
            System.out.printf("%.3f ", value);
        }
        System.out.println();
    }

    // Метод для сжатия массива: корни квадратные из положительных элементов, деленные на 5
    public static double[] compressAndTransformArray(int[] vector) {
        return Arrays.stream(vector)
                .filter(x -> x > 0)                 // Только положительные элементы
                .mapToDouble(x -> Math.sqrt(x) / 5) // Вычисляем sqrt(x)/5
                .toArray();                         // Преобразуем в массив
    }

    // Метод сортировки выбором
    public static void selectionSort(double[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Находим индекс минимального элемента
                }
            }
            // Меняем местами текущий элемент и минимальный
            double temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
