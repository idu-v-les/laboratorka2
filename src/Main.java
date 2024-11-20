import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Заполняем массив случайными числами
        int[] vector = fillRandomIntVector(30, 100, 200);

        // Вывод исходного массива
        printVector(vector, "Исходный массив:");

        // Сортируем массив
        Arrays.sort(vector);

        // Вывод отсортированного массива
        printVector(vector, "Отсортированный массив:");

        // Переписываем положительные элементы, умноженные на 5
        int[] compressedVector = compressPositiveElements(vector);
        printVector(compressedVector, "Сжатый массив положительных элементов, умноженных на 5:");
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

    // Метод для вывода массива с сообщением
    public static void printVector(int[] vector, String message) {
        System.out.println(message);
        for (int value : vector) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Метод для создания нового массива из положительных элементов, умноженных на 5
    public static int[] compressPositiveElements(int[] vector) {
        return Arrays.stream(vector)
                .filter(x -> x > 0) // Оставляем только положительные элементы
                .map(x -> x * 5)    // Умножаем на 5
                .toArray();         // Преобразуем в массив
    }
}
