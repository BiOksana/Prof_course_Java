package week6.lesson_31_10.homework;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // Exercise 1: Из изначально данного Set names получить Set длин имен

        Set<String> namesSet = new HashSet<>(List.of("Yulia", "Halina", "Svetlana", "Irina", "Alla", "Elena", "Klavdia", "Tatiana"));
        System.out.println("getNamesLengthSet(namesSet) = " + getNamesLengthSet(namesSet));

        // Exercise 2: Имеется текст "Hello world!!!". Вывести уникальный набор символов

        String text = "Hello world!!!";
        System.out.println("getUniqueCharacterSet from text: \'" + text + "\' : " + getUniqueCharacterSet(text));

        // Exercise 3: Напишите метод, чтобы получить первое и последнее вхождение элементов в отсортированном списке.
        //input:  list = {1, 1, 2, 2, 2, 2, 2, 2, 4, 4, 5, 7, 9, 10}, element = 2
        //output: 2 (индекс первого вхождения), 7 (индекс последнего вхождения)

        int[] array = {1, 1, 2, 2, 2, 2, 2, 2, 4, 4, 5, 7, 9, 10};
        System.out.println("индекс первого вхождения: " + findFirstPosition(array, 2) + ", индекс последнего вхождения: " + findLastPosition(array, 2));
    }

    private static Set<Character> getUniqueCharacterSet(String text) {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            characterSet.add(text.charAt(i));
        }
        return characterSet;
    }

    private static Set<Integer> getNamesLengthSet(Set<String> namesSet) {
        Set<Integer> setNamesLength = new HashSet<>();
        for (String name : namesSet) {
            System.out.println("name = " + name + ", name.length() = " + name.length());
            setNamesLength.add(name.length());
        }
        return setNamesLength;
    }

    private static int findFirstPosition(int[] items, int item) {
        int leftIndex = 0;
        int rightIndex = items.length - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            int foundElement = items[middleIndex];
            if (foundElement == item) {
                if (foundElement > items[middleIndex - 1]) {
                    System.out.println("middleIndex = " + (middleIndex));
                    return middleIndex;
                }
                rightIndex = middleIndex - 1;
            }
            if (foundElement > item) {
                rightIndex = middleIndex - 1;
            } else if (foundElement < item) {
                leftIndex = middleIndex + 1;
            }
        }
        return -1;
    }

    private static int findLastPosition(int[] items, int item) {
        int leftIndex = 0;
        int rightIndex = items.length - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            int foundElement = items[middleIndex];
            if (foundElement == item) {
                if (foundElement < items[middleIndex + 1]) {
                    return middleIndex;
                }
                leftIndex = middleIndex + 1;
            }
            if (foundElement > item) {
                rightIndex = middleIndex - 1;
            } else if (foundElement < item) {
                leftIndex = middleIndex + 1;
            }
        }
        return -1;
    }
}
