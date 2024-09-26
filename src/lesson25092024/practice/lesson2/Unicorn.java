package lesson25092024.practice.lesson2;

public class Unicorn extends Pegasus{

    private int cornsCount;

    public Unicorn(String name, String color, int weight, int wingsCount, int cornsCount) {
        super(name, color, weight, wingsCount);
        this.cornsCount = cornsCount;
    }

    //    public Unicorn(String name, String color, int weight, int wingsCount, int cornsCount) {
//        this.name = name;
//        this.color = color;
//        this.wingsCount = wingsCount;
//        this.weight = weight;
//        this.cornsCount = cornsCount;
//    }

//    public void fight() {
//        System.out.println(name + " unicorn, color " + color + " is fighting with " + cornsCount + " corns and "
//        + " is flying with " + wingsCount + " wings.");
//    }


    @Override
    public void fly() {
        super.fly();
    }

    public void fight() {
        System.out.println(name + " - " + getClass().getSimpleName()
                + ", color " + color + ", is fighting with " + cornsCount + " corns and "
        + " is flying with " + wingsCount + " wings.");
    }

}
