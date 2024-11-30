package week10.lesson_28_11.homework;

import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceMethod {
    //Переделать метод reduce() в классе ReduceMethod (см. пакет lesson20241119.hometasks) так, чтобы этот
    // метод мог производить операции над списками любого типа.

    public static void main(String[] args) {

        List<String> list = List.of("A", "B", "C", "D");
        System.out.println("reduce(list, String::concat, \"\") = " + reduce(list, String::concat, ""));
        System.out.println("reduce(list, (r, s) -> r.concat(s.toLowerCase()), \"\") = " + reduce(list, (r, s) -> r.concat(s.toLowerCase()), ""));
    }

    public static <T> T reduce(List<? extends T> list, BinaryOperator<T> operator, T basicValue) {
        T result = basicValue;
        for (int i = 0; i < list.size(); i++) {
            result = operator.apply(result, list.get(i));
        }
        return result;
    }
}
