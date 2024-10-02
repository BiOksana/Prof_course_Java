package week1.lesson24092024.inheritance.models;

import week1.lesson24092024.inheritance.interfaces.Walkable;

public class Human extends Creature implements Walkable {

    public Human(String name) {
        super(name);
    }

    @Override
    public void introduce() {
        System.out.println("Hi! I'm " + getClass().getSimpleName()
        + " My name is " + getName());
    }

    public void feedAnimal(Animal animal) {
        if (animal.isHungry()) {
            System.out.println("I'm feeding my " + animal.getClass().getSimpleName()
            + " named " + animal.getName());
            animal.setHungry(false);
        } else {
            System.out.println(animal.getClass().getSimpleName() + " named " + animal.getName()
            + " is not hungry.");
        }
    }

    public void feedAnimals(Animal... animals) {
        for (Animal animal : animals) {
            feedAnimal(animal);
            System.out.println(animal);
        }
    }

    public void walk(Animal animal) {
        System.out.println("I'm walking my " + animal.getClass().getSimpleName()
                + " named " + animal.getName());
        animal.setHungry(true);
    }


    @Override
    public void play(Creature another) {
        if (another != null && another instanceof Animal) {
            System.out.println("I'm " + getClass().getSimpleName() + " named "
                    + getName() + ". I'm playing with " + " my "
                    + another.getClass().getSimpleName() + " named "
                    + another.getName());
        } else {
            System.out.println("Something went wrong...");
        }
    }
}
