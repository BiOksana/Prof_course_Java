package week1.lesson24092024.inheritance;

import week1.lesson24092024.inheritance.interfaces.CatchingSkills;
import week1.lesson24092024.inheritance.interfaces.Walkable;
import week1.lesson24092024.inheritance.models.Animal;

public class Robot implements Walkable, CatchingSkills {
    private String name;
    private int id;

    private String version;

    public Robot(String name, int id) {
        this.name = name;
        this.id = id;
        this.version = "TelRan.ver 2.0";
    }

    @Override
    public void catchMouse() {
        System.out.println("I'm " + this + ". I just caught a mouse.");
    }

    @Override
    public void walk(Animal animal) {
        System.out.println("I'm " + this + ". I'm walking "
                + animal.getClass().getSimpleName()
                + " named " + animal.getName());
        animal.setHungry(true);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", version='" + version + '\'' +
                '}';
    }
}
