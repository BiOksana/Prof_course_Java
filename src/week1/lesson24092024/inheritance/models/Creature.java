package week1.lesson24092024.inheritance.models;

public abstract class Creature {
    private String name;

    public Creature(String name) {
        this.name = name;
    }

    public abstract void introduce();

    public String getName() {
        return name;
    }

    public abstract void play(Creature another);
}
