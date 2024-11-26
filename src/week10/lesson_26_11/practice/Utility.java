package week10.lesson_26_11.practice;

public class Utility {

    public static <T> void printArray(T[] array) {
        for (T elem : array) {
            System.out.println(elem);
        }
    }
}
