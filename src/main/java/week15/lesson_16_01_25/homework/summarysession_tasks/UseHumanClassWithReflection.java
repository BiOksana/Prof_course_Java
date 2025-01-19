package week15.lesson_16_01_25.homework.summarysession_tasks;

import week1.lesson24092024.inheritance.models.Animal;
import week1.lesson24092024.inheritance.models.Cat;
import week1.lesson24092024.inheritance.models.Human;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UseHumanClassWithReflection {
    /*
    2. Имеется класс lesson20240924.inheritance.Human. Через рефлексию
- вызвать методы introduce(), feedAnimal(Animal animal)
- создать экземпляр класса
     */
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, InstantiationException,
            IllegalAccessException, NoSuchFieldException {
        Class<?> humanClass = Class.forName("week1.lesson24092024.inheritance.models.Human");

        Human newInstanceOfHuman = (Human)Class.forName("week1.lesson24092024.inheritance.models.Human")
                .getConstructor(String.class).newInstance("Franz");
        System.out.println(newInstanceOfHuman.getName());

        Method introduceMethod = humanClass.getDeclaredMethod("introduce");
        introduceMethod.setAccessible(true);
        introduceMethod.invoke(newInstanceOfHuman);

        Animal cat = new Cat("Tim", 2);
        Method feedAnimalMethod = humanClass.getDeclaredMethod("feedAnimal", Animal.class);

        feedAnimalMethod.setAccessible(true);
        feedAnimalMethod.invoke(newInstanceOfHuman, cat);



    }
}
