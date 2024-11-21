package week9.lesson_21_11.practice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTasks {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("sumOfSquaresOfOddNumbers(numbers) = " + sumOfSquaresOfOddNumbers(numbers));

        List<String> strings = List.of("Specific", "Measurable", "Achievable", "Relevant", "Measurable", "Time-bounds");
        System.out.println("uniqueSortedWords(strings) = " + uniqueSortedWords(strings));

        System.out.println("uniqueChars(strings) = " + uniqueChars(strings));
        System.out.println("longestString(strings) = " + longestString(strings));
    }

    //Напишите метод, который принимает список чисел и возвращает
    // сумму квадратов всех нечетных чисел в списке.
    public static int sumOfSquaresOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .reduce(0, (r, n) -> r + n * n);
    }

    //Напишите метод, который принимает список строк и возвращает список уникальных слов,
    // отсортированных в лексикографическом порядке.
    public static List<String> uniqueSortedWords(List<String> strings) {
        return strings.stream()
                .distinct()
                .sorted()
                .toList();
    }

    //Напишите метод, который принимает список строк и возвращает список строк, содержащих
    // только уникальные символы (т.е. символы, которые не повторяются в строке).
    public static List<String> uniqueChars(List<String> strings) {
        return strings.stream()
                .map(s -> s.chars().boxed().map(Character::toString).distinct().collect(Collectors.joining()))
                .toList();
    }

    //Напишите метод, который принимает список строк и возвращает самую длинную строку в списке.
    public static String longestString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }
}
