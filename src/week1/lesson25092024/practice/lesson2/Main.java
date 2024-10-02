package week1.lesson25092024.practice.lesson2;

public class Main {
    public static void main(String[] args) {
        Horse horse1 = new Horse("Bobby", "black", 10);
        horse1.run();
        horse1.transport();
        System.out.println();

        Pegasus pegasus = new Pegasus("Star", "white", 5, 2);
        pegasus.fly();
        pegasus.run();
        pegasus.transport();
        System.out.println();

        Unicorn unicorn = new Unicorn("Onix", "grey", 14, 2,1);
        unicorn.run();
        unicorn.transport();
        unicorn.fight();
        unicorn.fly();
        System.out.println();

        UniPegasus uniPegasus = new UniPegasus("Tom", "Brown", 15, 4, 2);
        uniPegasus.run();
        uniPegasus.transport();
        uniPegasus.fly();
        uniPegasus.fight();

    }
}
