package week15.lesson_16_01_25.homework.summarysession_tasks;

import java.util.ArrayList;
import java.util.List;

public class Jokes {
    private List<String> jokeList;

    public Jokes() {
        fillJokeList();
    }

    private void fillJokeList() {
        jokeList = new ArrayList<>();
        jokeList.add("Joke 1");
        jokeList.add("Joke 2");
        jokeList.add("Joke 3");
        jokeList.add("Joke 4");
        jokeList.add("Joke 5");
        System.out.println(jokeList);
    }

    public List<String> getJokeList() {
        return jokeList;
    }
}
