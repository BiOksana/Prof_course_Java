package summerySession2709.game;

import summerySession2709.game.accessories.Protection;
import summerySession2709.game.accessories.Weapon;
import summerySession2709.game.characters.EvilCreature;
import summerySession2709.game.characters.Superhero;

public class SuperheroBattle {
    public void run() {
        EvilCreature evilCreature = new EvilCreature("Noob", generateForce(), generateProtection());
        Weapon weapon = new Weapon("Sword", generateForce());
        Protection protection = new Protection("Armor", generateProtection());
        Superhero superhero = new Superhero("Max", generateForce(), weapon, protection);
        evilCreature.introduce();
        superhero.introduce();
        System.out.println("Begin battle!!!");
        superhero.fight(evilCreature);
    }

    private int generateForce() {
        return (int) (Math.random() * 100 + 1);
    }

    private int generateProtection() {
        return (int) (Math.random() * 12 + 1);
    }
}
