package week9.lesson_19_11.homework_with_streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamHW {

    public static void main(String[] args) {

//    1. С помощью стримов посчитать количество неповторяющихся слов в списке
        List<String> strings = List.of("Apple", "Banana", "Cherry", "Apple", "Banana", "Orange", "Apple", "Grape",
                "Banana", "Mango", "Pineapple", "Orange", "Apple");

        Map<String, Long> collect = strings.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println(collect.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .count());

//С помощью стримов посчитать количество людей с именем "Tom" в списке имен

        List<String> names = List.of("Tom", "Sarah", "Tom", "Michael", "Emily", "Anna", "Michael", "Tom");

        System.out.println("count of people with Tom name = " + names.stream()
                .filter(s -> s.equals("Tom"))
                .count());

//Из списка имен вывести первые три по алфавиту:
        names.stream()
                .sorted()
                .limit(3)
                .forEach(System.out::println);

//Из списка имен вывести предпоследнее имя по алфавиту:
        System.out.println("previous name in list = " + names.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .toList());

// Создать список из экземпляров класса Cat.
        List<Cat> cats = new ArrayList<>(List.of(
                new Cat("Tom", 5, "grey", false),
                new Cat("Vasiliy", 4, "black", true),
                new Cat("Tima", 2, "grey", false),
                new Cat("Bonia", 3, "white", false),
                new Cat("Kuzma", 1, "red", true),
                new Cat("Leopold", 4, "tabby", false),
                new Cat("Murka", 9, "black", false),
                new Cat("Timofei", 6, "grey", true),
                new Cat("Barsik", 8, "white", false)
        ));


// С помощью стримов: вывести список голодных кошек старше 2 лет
        List<Cat> hungryCatsWithAgeMore2 = cats.stream()
                .filter(cat -> cat.isHungry() && cat.getAge() > 2)
                .toList();
        System.out.println("hungryCatsWithAgeMore2 = " + hungryCatsWithAgeMore2);

//вывести список уникальных цветов кошек
        List<String> uniqueColorsOfCats = cats.stream()
                .map(cat -> cat.getColour())
                .distinct()
                .toList();
        System.out.println("uniqueColorsOfCats = " + uniqueColorsOfCats);


//вывести список имен кошек возраста 1 год
        List<String> catNamesWithAge1 = cats.stream()
                .filter(cat -> cat.getAge() == 1)
                .map(Cat::getName)
                .toList();
        System.out.println("catNamesWithAge1 = " + catNamesWithAge1);
    }
}
