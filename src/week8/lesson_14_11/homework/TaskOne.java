package week8.lesson_14_11.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class TaskOne {
//    1. Создать Supplier randomJoke, который выдает пользователю случайный анекдот из заготовленного исходного списка анекдотов.
public static void main(String[] args) {
    List<String> jokes = new ArrayList<>(List.of("- Why did the programmer quit his job?\n- He didn’t get arrays!\n",
            "- Why do Java developers wear glasses?\n- Because they can’t C#.\n",
            "- How many programmers does it take to change a light bulb?\n- None. It’s a hardware problem!\n",
            "- Why was the JavaScript developer sad?\n- Because he didn’t know how to null his feelings.\n",
            "- Why do programmers prefer dark mode?\n- Because light attracts bugs!\n",
            "- Why was the function afraid to call another function?\n- It didn’t want to be stuck in a loop.\n",
            "- Why was the Java class so proud of itself?\n- Because it had all the right fields!\n",
            "- What’s a programmer’s favorite hangout place?\n- The Foo Bar.\n"));


    Supplier randomJoke = () -> jokes.get((int) (Math.random() * jokes.size()));
    System.out.println(randomJoke.get());

}
}
