package week6.lesson_29_10.homework;

import week3.lesson08102024.homework.Student;

import java.util.*;

public class Main {
//1. Создать класс Student с полями name, surname. Определить порядок студентов через Comparable (natural ordering)
//с учетом всех полей. Создать компараторы по отдельным полям name, surname.
//Составить список студентов. Вывести отсортированный список студентов - через Comparable и два компаратора.
//Составить TreeSet из исходного списка студентов.


    public static void main(String[] args) {
        Student student1 = new Student("Anton", "Sidorov");
        Student student2 = new Student("Sergey", "Petrov");
        Student student3 = new Student("Mikhail", "Andreev");
        Student student4 = new Student("Anrew", "Sergeev");
        Student student5 = new Student("Oleg", "Ivanov");
        Student student6 = new Student("Irina", "Alexeeva");
        Student student7 = new Student("Svetlana", "Egorova");
        Student student8 = new Student("Oleg", "Svetlov");
        Student student9 = new Student("Nata", "Pavlova");
        Student student10 = new Student("Elena", "Nikolaeva");
        Student student11 = new Student("Ihor", "Belov");
        Student student12 = new Student("Lev", "Shevchenko");

        List<Student> students1 = new LinkedList<>(List.of(student1, student2, student3, student4, student5, student6,
                student7, student8, student9, student10, student11, student12));

        TreeSet<Student> studentTreeSet = new TreeSet<>(List.of(student1, student2, student3, student4, student5, student6,
                student7, student8, student9, student10, student11, student12));

        System.out.println("TreeSet of List.of.studends: ");
        for (Student student : studentTreeSet) {
            System.out.println(student.getName() + " " + student.getSurname());
        }

        Set<Student> studentSet = new TreeSet<>(students1);

        System.out.println("Set of List.ofStudentLinkedList: ");
        for (Student student : studentSet) {
            System.out.println(student.getName() + " " + student.getSurname());
        }

        List<Student> students2 = new LinkedList<>(List.of(student11, student2, student3, student5, student8, student6, student1,
                student7, student4, student10, student9, student12));

        Set<Student> studentSet2 = new TreeSet<>(students2);

        System.out.println("Set of List.ofStudentLinkedList2: ");
        for (Student student : studentSet2) {
            System.out.println(student.getName() + " " + student.getSurname());
        }

        for (Student student : students1) {
            System.out.println(student.getName() + " " + student.getSurname());
        }

        for (Student student : students2) {
            System.out.println(student.getName() + " " + student.getSurname());
        }

//    Collections.sort(students1);
//    Collections.sort(students2);
        Collections.sort(students1, new Student.StudentComparatorBySurname());
        Collections.sort(students1, new Student.StudentComparatorByName());

        Collections.sort(students2, new Student.StudentComparatorByName());
        Collections.sort(students2, new Student.StudentComparatorBySurname());

        System.out.println("Sorted lists: 0");
        for (Student student : students1) {
            System.out.println(student.getName() + " " + student.getSurname());
        }

        for (Student student : students2) {
            System.out.println(student.getName() + " " + student.getSurname());
        }
    }
}
