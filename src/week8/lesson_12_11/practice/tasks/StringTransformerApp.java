package week8.lesson_12_11.practice.tasks;

import java.util.ArrayList;
import java.util.List;

public class StringTransformerApp {
    //    Создайте два функциональных интерфейса: StringTransformer и StringPrinter. StringTransformer должен принимать строку и
//    возвращать новую строку, измененную определенным образом (например, переведенную в верхний регистр), а StringPrinter — выводить
//    строку в консоль. Напишите метод, который принимает список строк и последовательно применяет к ним StringTransformer и StringPrinter.
    public static void main(String[] args) {
        List<String> text = new ArrayList<>(List.of("Hello", "world", "and", "hello", "Java"));

        new StringTransformerApp().process(s -> s.toUpperCase(), s -> System.out.println(s), text);

//        new LambdaEx().process(new StringTransformer() {
//            @Override
//            public String transform(String s) {
//                return s.toUpperCase();
//            }
//        }, new StringPrinter() {
//            @Override
//            public void print(String s) {
//                System.out.println(s);
//            }
//        }, text);

    }

    public void process(StringTransformer stringTransformer, StringPrinter stringPrinter, List<String> strings) {
        for (String string : strings) {
            String newString = stringTransformer.transform(string);
            stringPrinter.print(newString);
        }
    }
}

@FunctionalInterface
interface StringTransformer {
    String transform(String s);
}

@FunctionalInterface
interface StringPrinter {
    void print(String s);
}