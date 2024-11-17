package week8.lesson_14_11.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class TaskFour {
    //4.Написать метод reduce(), который на вход принимает список чисел, оператор двух аргументов и начальное значение.
//public static Integer reduce(List<Integer> list, BinaryOperator<Integer> operator, Integer basicValue)
//Метод накапливает результат применения оператора по всем данных, начиная с начального значения.
//Например, вызов
//    reduce(list, Integer::sum, 0)) должен вернуть сумму всех чисел
//    reduce(list, (i, j) -> i * j, 1) должен вернуть произведение всех чисел
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(reduce(numbers, Integer::sum, 0));
        System.out.println("reduce(numbers, (i, j) -> i * j, 1) = " + reduce(numbers, (i, j) -> i * j, 1));

    }

    public static Integer reduce(List<Integer> list, BinaryOperator<Integer> operator, Integer basicValue) {
        int result = basicValue;
        for (Integer integer : list) {
            result = operator.apply(result, integer);
        }
        return result;
    }
}
