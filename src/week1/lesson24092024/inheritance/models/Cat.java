package week1.lesson24092024.inheritance.models;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    public void meow() {
        System.out.print("Meow!");
    }

    @Override
    public void introduce() {
        System.out.println("Hello!" + " I'm " + this.getClass().getSimpleName()
                + ". My name is " + getName());
    }

    @Override
    public void play(Creature another) {
        meow();
        System.out.println(" I want to play with you!");
    }
}