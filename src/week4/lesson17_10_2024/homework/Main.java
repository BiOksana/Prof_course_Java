package week4.lesson17_10_2024.homework;

import week3.lesson08102024.homework.Student;

import java.util.*;

public class Main {
    // 1. Составить список списков студентов, распределенных по отдельным классам List> studentGrades
// Написать метод countTotalAmount(), который считает общее число студентов
// Написать метод countAmountWithName(String name), который считает количество студентов в школе с
// заданным именем name.
//
//2. Имеется заданный список имен студентов:
//List names = new ArrayList<>(List.of("Mary", "Jane", "Tom", "Tim", "Mark", "Ann", null, ""));
//С помощью итератора:
//a). Вывести имена, состоящие из 4 букв
//b). Удалить из списка null и пустые строки.

    public static void main(String[] args) {
        Student student1 = new Student("Anton", "Sidorov");
        Student student2 = new Student("Sergey", "Petrov");
        Student student3 = new Student("Mikhail", "Andreev");
        Student student4 = new Student("Andrew", "Sergeev");
        Student student5 = new Student("Olga", "Ivanova");
        Student student6 = new Student("Elena", "Alexeeva");
        Student student7 = new Student("Svetlana", "Egorova");
        Student student8 = new Student("Oleg", "Svetlov");
        Student student9 = new Student("Andrew", "Pavlov");
        Student student10 = new Student("Elena", "Nikolaeva");
        Student student11 = new Student("Ihor", "Belov");
        Student student12 = new Student("Andrew", "Shevchenko");

        List<Student> studentsOfFirstGrade = new ArrayList<>(List.of(student1, student12, student7));
        List<Student> studentsOfSecondGrade = new ArrayList<>(List.of(student11, student2, student4));
        List<Student> studentsOfThirdGrade = new ArrayList<>(List.of(student5, student3, student8));
        List<Student> studentsOfFourthGrade = new ArrayList<>(List.of(student10, student6, student9));

        // Exercise 1:
        List<List<Student>> generalList = new ArrayList<>(List.of(studentsOfFirstGrade, studentsOfSecondGrade, studentsOfThirdGrade, studentsOfFourthGrade));

        System.out.println("countTotalAmount = " + countTotalAmount(generalList));
        System.out.println("countAmountWithName = " + countAmountWithName(generalList, "Andrew"));

//            List<String> names = new ArrayList<>(List.of("Mary", "Jane", "Tom", "Tim", "Mark", "Ann", null, ""));          ???????????
        List<String> names = new ArrayList<>(Arrays.asList("Mary", "Jane", "Tom", "Tim", "Mark", "Ann", null, ""));
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name != null && name.length() == 4) {
                System.out.println(name);       // Ex. 2a
            }
            if (name == null || Objects.equals(name, "")) {
                iterator.remove();                  // Ex. 2b
            }
        }
        System.out.println(names);

    }

    private static int countAmountWithName(List<List<Student>> list, String name) {
        int count = 0;
        for (List<Student> students : list) {
            for (Student student : students) {
                if (Objects.equals(student.getName(), name)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int countTotalAmount(List<List<Student>> generalList) {
        int count = 0;
        for (List<Student> students : generalList) {
            count += students.size();
        }
        return count;
    }
}
