package week8.lesson_12_11.practice.tasks;

public class NumberProcessorApp {
    //    Создайте интерфейс NumberProcessor, который принимает число и возвращает число. Напишите несколько реализаций
//    этого интерфейса, таких как добавить 5, удвоить, возвести в квадрат, и составьте цепочку функций, которая применяет их последовательно.
//    Реализуйте метод compose для создания цепочек функций, который принимает несколько реализаций NumberProcessor и возвращает результат их
//    последовательного применения.
    public static void main(String[] args) {
        System.out.println(NumberProcessorApp.compose(new IncreaseByFive(), new DoubleNumber(), new SquareNumber(), 1));
    }


    public static int compose(IncreaseByFive increaseByFive, DoubleNumber doubleNumber, SquareNumber squareNumber, int number) {
        return squareNumber.process(doubleNumber.process(increaseByFive.process(number)));
    }

}

class SquareNumber implements NumberProcessor {
    @Override
    public int process(int number) {
        return number *= number;
    }
}
class DoubleNumber implements NumberProcessor {
    @Override
    public int process(int number) {
        return number *= 2;
    }
}

class IncreaseByFive implements NumberProcessor {
    @Override
    public int process(int number) {
        return number += 5;
    }
}

@FunctionalInterface
interface NumberProcessor {
    int process(int number);
}
