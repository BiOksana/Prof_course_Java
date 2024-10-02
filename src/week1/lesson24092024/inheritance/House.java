package week1.lesson24092024.inheritance;

import week1.lesson24092024.inheritance.models.Cat;
import week1.lesson24092024.inheritance.models.Dog;
import week1.lesson24092024.inheritance.models.Human;

public class House {
//    класс Creature был бы абстрактным классом на верху иерархии всех обитателей дома
//    класс Creature содержал бы поле String name
//
//    метод abstract void introduce() находился бы в Creature
//
//    Human и Animal наследовали от Creature
//
//    у класса Human появилась возможность выгуливать животных, метод walk(Animal animal)
//    После прогулки животное становится голодным.
//
//
//
//    Создать метод play(Creature another) так, чтобы все обитатели дома умели бы играть друг
//    с другом. При игре выводится сообщение о том, кто с кем играет. Доработать метод
//    play() у подклассов так, чтобы при попытке игры кошек с собаками:
//            dog.play(cat) - собака бы лаяла на кошку
//             cat.play(dog) - кошка бы убегала
//
//    С применением интерфейсов:
//    Создать класс Robot c полями name, id, version
//
//    У классов Human и Robot добавить возможность выгуливать животных,
//    метод walk(Animal animal) интерфейса Walkable
//
//    У классов Cat и Robot добавить возможность поимки мышей, метод catchMouse()
//    интерфейса CatchingSkills
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
        human.feedAnimal(cat);
        human.walk(cat);
        human.feedAnimal(cat);
        human.feedAnimal(cat);
        cat.play(dog);
        dog.play(cat);
        cat.catchMouse();
        Robot robot = new Robot("Merlin", 4);
        robot.walk(dog);
        human.feedAnimal(dog);
        robot.catchMouse();
        human.play(dog);
    }

}
