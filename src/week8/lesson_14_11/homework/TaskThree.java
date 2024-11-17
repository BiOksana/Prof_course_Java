package week8.lesson_14_11.homework;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class TaskThree {
    //3. Создать три функции:
//    f1 - умножает Integer на 10
//    f2 - преобразует Integer в String в формате "<<123>>"
//    f3 - считает число символов в String
//Составить композитную функцию так, чтобы:
//      а) функции выполнялись последовательно друг за другом f1 -> f2 -> f3
//Input: 777
//Output: 8
//      б) в порядке f3 -> f1 -> f2
//Input: "Hello!"
//Output: "<<60>>"
    public static void main(String[] args) {
        UnaryOperator<Integer> multiplyBy10 = integer -> integer * 10;
        Function<Integer, String> convertIntToString = integer -> "<<" + integer + ">>";
        Function<String, Integer> getLengthOfString = String::length;

        System.out.println(multiplyBy10.andThen(convertIntToString).andThen(getLengthOfString).apply(777));
        System.out.println(getLengthOfString.compose(convertIntToString).compose(multiplyBy10).apply(777));

        System.out.println();
        System.out.println(getLengthOfString.andThen(multiplyBy10).andThen(convertIntToString).apply("Hello!"));
        System.out.println(convertIntToString.compose(multiplyBy10).compose(getLengthOfString).apply("Hello!"));

    }
}
