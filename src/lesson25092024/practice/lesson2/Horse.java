package lesson25092024.practice.lesson2;

public class Horse {

    protected String name;
    protected String color;

    protected int weight;

    public Horse() {
    }

    public Horse(String name, String color, int weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public void run() {
        System.out.println(name + " - " + getClass().getSimpleName()
                + " , color " + color + " is running");
    }

    public void transport() {
        System.out.println(name + " - " + getClass().getSimpleName() + "  carrying " + weight);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
