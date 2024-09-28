package summarySession2709.homework1.game.characters;

import summarySession2709.homework1.game.accessories.Protection;
import summarySession2709.homework1.game.accessories.Weapon;

public class Superhero extends Character {
    private int force;
    private Weapon weapon;
    private Protection protection;

    public Superhero(String name, int force, Weapon weapon, Protection protection) {
        super(name);
        this.force = force;
        this.weapon = weapon;
        this.protection = protection;
    }

    @Override
    public int countForce() {
        return force + weapon.getForce();
    }

    @Override
    public int countProtection() {
        return protection.getLevel();
    }

}
