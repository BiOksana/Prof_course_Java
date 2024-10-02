package week1.lesson24092024.inheritance.models;

import week1.lesson24092024.inheritance.models.Animal;
import week1.lesson24092024.inheritance.models.Creature;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    public void gav() {
        System.out.print("Gav! Gav!");
    }

    @Override
    public void introduce() {
        System.out.println("Hello!" + " I'm " + this.getClass().getSimpleName()
                + ". My name is " + getName());
    }

    @Override
    public void play(Creature another) {
        gav();
        System.out.println(" I want to play with you!");

    }
}
