package lesson24092024.inheritance;

public class Human {

    private String name;

    public Human(String name) {
        this.name = name;
    }

    public void feedAnimal(Animal animal) {
        if (animal.isHungry()) {
            System.out.println(("I'm feeding " + animal.getClass().getSimpleName()));
            animal.setHungry(false);
        }
    }

    public void feedAnimals(Animal... animals) {
        for (Animal animal : animals) {
            feedAnimal(animal);
            System.out.println(animal);
        }
    }

}
