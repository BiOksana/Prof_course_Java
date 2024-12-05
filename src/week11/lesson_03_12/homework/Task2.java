package week11.lesson_03_12.homework;

import java.io.IOException;

public class Task2 {
// 2. Один метод вызывает три других метода, которые выбрасывают проверяемые и непроверяемые исключения:
// Отловить эти исключения и выбросить вместо них MyAppException, который содержал бы информацию о типе
// исходного исключения и его сообщение.

    public static void main(String[] args) {
        superMethod();
    }

    public static void superMethod() {
        try {
            method1();
            method2();
            method3();
        } catch (Exception e) {
            throw new MyAppException(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }

    public static void method1() {
        System.out.println(1 / 0);
    }

    public static void method2() {
        throw new NullPointerException("nulls everywhere!");
    }

    public static void method3() throws IOException {
        throw new IOException("File not found");
    }
}
