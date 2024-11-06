package week7.lesson_05_11.homework.priority_queue;

public class Good implements Comparable<Good> {
    private String name;
    private int price;

    public Good(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Good another) {
        return this.price - another.price;
    }
}
