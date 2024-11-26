package week10.lesson_26_11.practice;

import java.util.Locale;

public class Tasks {

    public static void main(String[] args) {
//    Задание 1:
//Создайте обобщенный класс Box, который может хранить объект любого типа.
//Реализуйте методы для установки и получения значения.

        Box<String> box = new Box<>("Hello");
        System.out.println("box.getElement() = " + box.getElement());
        box.setElement(box.getElement() + ", Java");
        System.out.println("box.getElement() = " + box.getElement());

        Box<Integer> boxOfInt = new Box<>(1);
        System.out.println("boxOfInt.getElement() = " + boxOfInt.getElement());
        boxOfInt.setElement(boxOfInt.getElement() * 100);
        System.out.println("boxOfInt.getElement() = " + boxOfInt.getElement());

        //Задание 2:
//Создайте обобщенный класс Pair, который хранит два объекта,
//возможно, разных типов. Реализуйте методы для установки и получения каждого значения.

        Pair<String, Integer> pair = new Pair<>("Hello", 20);
        System.out.println("pair.getElem1() = " + pair.getElem1());
        System.out.println("pair.getElem2() = " + pair.getElem2());
        pair.setElem1(pair.getElem1().toUpperCase());
        pair.setElem2(10);
        System.out.println("pair.getElem1() = " + pair.getElem1());
        System.out.println("pair.getElem2() = " + pair.getElem2());

        //Задание 3:
//В не обобщенном классе Utility реализуйте статический обобщенный
//метод printArray, который может выводить элементы любого массива.

        Integer[] numbers = {1, 2, 4, 3, 8};
        String[] strings = {"Hello", "my", "world", "of", "Java"};
        Utility.printArray(numbers);
        Utility.printArray(strings);

        //Задание 4:
//Создайте обобщенный интерфейс MyComparable<T> с методом int compareTo(T o).
//Затем создайте класс MyNumber, который реализует MyComparable<MyNumber>.

        MyNumber myNumber1 = new MyNumber(17.5f);
        MyNumber myNumber2 = new MyNumber(17);
        System.out.println("myNumber2.compareTo(myNumber1) = " + myNumber2.compareTo(myNumber1));

        //Задание 5:
//Создайте обобщенный класс NumberBox<T extends Number>, который может хранить числа.
//Реализуйте метод double sum(NumberBox<? extends Number> other), который складывает значения двух экземпляров NumberBox.
        NumberBox<Integer> integerNumberBox = new NumberBox<>(45);
        NumberBox<Float> floatNumberBox = new NumberBox<>(34.0f);
        System.out.println("numberBox.sum(floatNumberBox) = " + integerNumberBox.sum(floatNumberBox));
    }
}
