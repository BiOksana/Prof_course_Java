package week13.summarysession;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    //  1. Спортивное соревнование. Бегут 3 бегуна. Каждый пробегает дистанцию за случайное время.
//Каждый бегун земеряет свой результат и сообщает его тренеру. В конце забега выводится информация о победителе.
//Реализовать данную модель с помощью запуска отдельных потоков. Бегуна представить через класс Runner implements Runnable.
    public static void main(String[] args) {
        Runner runner1 = new Runner();
        Thread thread1 = new Thread(runner1, "Runner1");

        Runner runner2 = new Runner();
        Thread thread2 = new Thread(runner2, "Runner2");

        Runner runner3 = new Runner();
        Thread thread3 = new Thread(runner3, "Runner3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Map<String, Long> results = new HashMap<>();
        results.put(thread1.getName(), runner1.getResult());
        results.put(thread2.getName(), runner2.getResult());
        results.put(thread3.getName(), runner3.getResult());

        Map.Entry<String, Long> winner = results.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .get();

        System.out.println("Winner is " + winner.getKey() + ", his time is : " + winner.getValue());


    }

    static class Runner implements Runnable {
        private long result;

        public long getResult() {
            return result;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " is running");

            try {
                Thread.sleep((int) (Math.random() * 2001 + 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (Runner.class) {
                System.out.println(Thread.currentThread().getName() + " is running over the bridge");
                try {
                    Thread.sleep((int) (Math.random() * 1001 + 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " left the bridge");
            }

            long finish = System.currentTimeMillis();
            result = finish - start;
            System.out.println(Thread.currentThread().getName() + " finished for time " + result);
        }
    }
}
