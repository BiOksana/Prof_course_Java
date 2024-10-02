package week1.lesson24092024.inheritance.models;

import week1.lesson24092024.inheritance.interfaces.CatchingSkills;

public class Cat extends Animal implements CatchingSkills {

    public Cat(String name, int age) {
        super(name, age);
    }

    public void meow() {
        System.out.print(" Meow!");
    }

    @Override
    public void introduce() {
        System.out.print("I'm " + this.getClass().getSimpleName()
                + " named " + getName() + ":");
    }

    @Override
    public void play(Creature another) {
        introduce();
        meow();
        System.out.println(" I'm running away from you!");
    }

    @Override
    public void catchMouse() {
        introduce();
        System.out.print(" I just caught a mouse.\n");
    }
}