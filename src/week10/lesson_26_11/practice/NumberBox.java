package week10.lesson_26_11.practice;

public class NumberBox<T extends Number> {

    private T number;

    public NumberBox(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public double sum(NumberBox<? extends Number> other) {
        return number.doubleValue() + other.getNumber().doubleValue();
    }
}
