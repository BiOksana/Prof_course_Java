package week14.summarySession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Task2 {

//2. Имеется список. Один поток проходит итератором по списку и печатает его значения,
//второй поток в это же время меняет значение / удаляет элемент из списка.
//Продемонстрировать, что будет, если список:
//- ArrayList,
//- SynchronizedList,
//- ConcurrentLinkedQueue,
//- CopyOnWriteArrayList

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Hello!", "Hi!", "How’s it going?", "I’m great", "And you?", "Can’t complain", "exit"));
        List<String> synchronizedList = Collections.synchronizedList(list);

        Thread thread1 = new Thread(() -> {
            synchronized (synchronizedList) {
                Iterator<String> iterator = synchronizedList.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (synchronizedList) {
                Iterator<String> iterator = synchronizedList.iterator();

                while (iterator.hasNext()) {

                    String string = iterator.next();
                    if (string.equals("Hi!")) {
                        iterator.remove();
                    }
                }
            }
        });
                thread2.start();


                try {
                    thread1.join();
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(list);
            }
        }
