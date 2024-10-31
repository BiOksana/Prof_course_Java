package week5.lesson_24_10_2024.homework;

import week3.lesson08102024.homework.Student;

import java.util.*;

public class Main {
    //1. Перебрать LinkedList и найти самую короткую строку.
//2. Перебрать LinkedList и объединить все строки в одну с использованием разделителя "|".
//3. Создать LinkedList с объектами вашего собственного класса и удалить все элементы, удовлетворяющие определенному условию.
//4. Напишите метод, чтобы получить первое и последнее вхождение указанных элементов в связанном списке.
//input:
//list = {1, 4, 3, 2, 1, 2, 2, 0}, element = 2
//output:
//3 (индекс первого вхождения), 6 (индекс последнего вхождения)
    public static void main(String[] args) {

        List<String> list = new LinkedList<>(List.of("Success", "is", "not", "final", "failure", "is", "not", "fatal", "It", "is", "the", "courage", "to", "continue", "that", "counts"));
//    List<String> list = new LinkedList<>(List.of("I", "like", "to", "study", "Java"));
        System.out.println("findTheShortestString(list) = " + findTheShortestString(list));   //Ex. 1
        System.out.println("mergeAllStrings(list) = " + mergeAllStrings(list));               //Ex. 2
        Student student1 = new Student("Anton", "Sidorov");
        Student student2 = new Student("Sergey", "Petrov");
        Student student3 = new Student("Mikhail", "Andreev");
        Student student4 = new Student("Anrew", "Sergeev");
        Student student5 = new Student("Olga", "Ivanova");
        Student student6 = new Student("Irina", "Alexeeva");
        Student student7 = new Student("Svetlana", "Egorova");
        Student student8 = new Student("Oleg", "Svetlov");
        Student student9 = new Student("Nata", "Pavlova");
        Student student10 = new Student("Elena", "Nikolaeva");
        Student student11 = new Student("Ihor", "Belov");
        Student student12 = new Student("Lev", "Shevchenko");

        List<Student> students = new LinkedList<>(List.of(student11, student2, student3, student5, student8, student6, student1,
                student7, student4, student10, student9, student12));

        System.out.println("Exercise 3 with iterator: ");
        System.out.println("Count of students before removing: " + students.size());
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().length() < 5) {
                System.out.println(student.getName() + " " + student.getSurname());
                iterator.remove();
            }
        }
        System.out.println("Count of students after removing: " + students.size());

        System.out.println("Exercise 4: ");
        List<Integer> listOfNumbers = new LinkedList<>(List.of(1, 4, 3, 2, 1, 2, 2, 0));
        System.out.println(getFirstIndexesAndLastIndexOfNumber(listOfNumbers, 1));
    }

    private static String getFirstIndexesAndLastIndexOfNumber(List<Integer> list, int keyNumber) {
        ListIterator<Integer> iterator = list.listIterator();
        StringBuilder stringBuilder = new StringBuilder();
        int currentIndex = 0;
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number == keyNumber && currentIndex == 0 && stringBuilder.isEmpty()) {
                currentIndex = iterator.previousIndex();
                stringBuilder.append(currentIndex).append(" - индекс первого вхождения");
            } else if (number == keyNumber) {
                currentIndex = iterator.previousIndex();
            }
        }
        stringBuilder.append(", ").append(currentIndex).append(" - индекс последнего вхождения");
        return stringBuilder.toString();
    }

    private static String mergeAllStrings(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                stringBuilder.append(list.get(i)).append("|");
            } else {
                stringBuilder.append(list.get(i));
            }
        }
        return stringBuilder.toString();
    }

    private static int findTheShortestString(List<String> list) {
        int length = Integer.MAX_VALUE;
        for (String s : list) {
            if (s.length() < length) {
                length = s.length();
            }
        }
        return length;
    }
}
