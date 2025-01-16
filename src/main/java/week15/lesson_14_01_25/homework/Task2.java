package week15.lesson_14_01_25.homework;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
     //2. Составить массив с большим объемом тестовых данных. С помощью стримов отсортировать данные
    // - последовательно
    // - параллельно
    //Замерить и сравнить затраченное время.
    public static void main(String[] args) {

        int[] array = generateRandomArray(10000000);
        int[] arrayForSequentialSorting = Arrays.copyOf(array, array.length);
        int[] arrayForParallelSorting = Arrays.copyOf(array, array.length);
        long before = System.currentTimeMillis();
        int[] sequentiallySortedArray = Arrays.stream(arrayForSequentialSorting).sorted().toArray();  // 1707
//        Arrays.sort(arrayForSequentialSorting);  // 1478
        long after = System.currentTimeMillis();
        System.out.println("sequentiallySortedArray : execution time " + (after - before));

        array = generateRandomArray(1000000);
        before = System.currentTimeMillis();
        int[] parallelSortedArray = Arrays.stream(arrayForParallelSorting).parallel().sorted().toArray();  // 707
//        Arrays.parallelSort(arrayForParallelSorting);  // 531
        after = System.currentTimeMillis();
        System.out.println("parallelSortedArray : execution time " + (after - before));
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}
