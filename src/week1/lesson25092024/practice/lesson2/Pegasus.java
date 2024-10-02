package week1.lesson25092024.practice.lesson2;

public class Pegasus extends Horse{

    protected int wingsCount;

    public Pegasus(String name, String color, int weight, int wingsCount) {
        super(name, color, weight);
        this.wingsCount = wingsCount;
    }

    public void fly() {
        System.out.println(name + " - " + getClass().getSimpleName()  + " , color " + color
                + " is flying with " + wingsCount + " wings.");

    }
}
