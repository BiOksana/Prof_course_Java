package lesson24092024.inheritance;

public class House {

    public static void main(String[] args) {
        Cat cat = new Cat("Tom", 2);
        Dog dog = new Dog("Maks", 1);

//        cat.meow();
//        dog.gav();

//        cat.introduce();
//        dog.introduce();

//        Animal animal = new Dog("Dog", 2);
//        animal.introduce();
//        animal = new Cat("Tima", 1);
//        animal.introduce();

        Human human = new Human("Ivan");
        human.feedAnimals(cat, dog);
    }

}
