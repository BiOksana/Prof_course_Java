package lesson25092024.practice.lesson2;

public class UniPegasus extends Unicorn {

//    private int cornsCount;

    public UniPegasus(String name, String color, int weight, int wingsCount, int cornsCount) {
        super(name, color, weight, wingsCount, cornsCount);
//        this.cornsCount = cornsCount1;
    }

    //    public UniPegasus(String name, String color, int weight, int wingsCount, int cornsCount) {
//        super(name, color, weight, wingsCount);
//        this.cornsCount = cornsCount;
//    }


    @Override
    public void fight() {
        super.fight();
    }

    @Override
    public void fly() {
        super.fly();
    }

//    public void fightAndFlight() {
//        System.out.println(name + " unipegasus, color " + color + " is fighting with " + cornsCount + " corns."
//        + " is flying with " + wingsCount + " wings.");
//    }
}
