package summarySession2709.homework1.game.characters;

public abstract class Character {

    private String name;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public void introduce() {
        System.out.print("Hi! I'm " + getName());
        System.out.printf(". I have %d health, %d force, %d protection.\n",
                health, countForce(), countProtection());
    }

    public abstract int countForce();

    public abstract int countProtection();

    public void fight(Character another) {
        if (countForce() > another.countForce()) {
            another.health = another.health - (countForce() - another.countForce()) / another.countProtection();
            System.out.println(name + " has won! His health is " + health);
            System.out.println(another.name + " has lost. His health is " + another.health);
        } else if (another.countForce() > countForce()) {
            health = health - (another.countForce() - countForce()) / countProtection();
            System.out.println(another.name + " has won! His health is " + another.health);
            System.out.println(name + " has lost. His health is " + health);
        } else {
            System.out.println("Draw!");
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
