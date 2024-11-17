package week8.lesson_14_11.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TaskTwo {
    //    Создать Consumer, который принимает числа и печатает четные числа в поток System.out, а нечетные числа в System.err.
    public static void main(String[] args) {
        Consumer<Integer> consumer = integer -> {
            if (integer % 2 == 0) {
                System.out.println(integer);
            } else {
                System.err.println(integer);
            }
        };
        List<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            numbersList.add((int) (Math.random() * 100 + 1));
        }
        System.out.println(numbersList);
        for (Integer integer : numbersList) {
            consumer.accept(integer);
        }

    }

}
