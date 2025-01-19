package week15.lesson_16_01_25.homework.summarysession_tasks;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class UseJokesClassWithReflection {
    /*
3. Имеется класс lesson20241119.hometasks.Jokes. Через рефлексию
заменить список исходных шуток в классе.
     */

    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, NoSuchFieldException {
        List<String> newListOfJokes = List.of("New joke 1", "New joke 2", "New joke 3", "New joke 4", "New joke 5");

        Jokes jokes = new Jokes();
        System.out.println(jokes.getJokeList());
        Class<? extends Jokes> jokesClass = jokes.getClass();

        Field jokeListField = null;
        for (Field field : jokesClass.getDeclaredFields()) {
            jokeListField = jokesClass.getDeclaredField(field.getName());
        }

        if (jokeListField != null) {
            jokeListField.setAccessible(true);
            jokeListField.set(jokes, newListOfJokes);
        }
        System.out.println(jokes.getJokeList());


    }
}
