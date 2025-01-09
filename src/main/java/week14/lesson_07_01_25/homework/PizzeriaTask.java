package week14.lesson_07_01_25.homework;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PizzeriaTask {
    /*
Реализовать модель кафе: один повар и много посетителей. Посетители посещают кафе со случайной периодичностью.
Каждого посетителя представить как отдельный поток. Повар готовит пиццу, кладет ее на прилавок (в блокирующую очередь).
При наличии трех готовых пицц повар отдыхает.
    один посетитель (отдельный поток)
    - заходит в кафе
    - ждет пиццу на прилавке
    - ест пиццу
    - покидает кафе
    повар (отдельный поток)
    - готовит пиццу
    - кладет ее на прилавок (в блокирующую очередь)
    - отдыхает, если готовых пицц уже 3 шт.
     */

    static BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

    public static void main(String[] args) {
        new Thread(new Chef(queue), "Chef").start();

        int i = 1;
        while (true) {
            new Thread(new Visitor(queue), "Visitor " + i++).start();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Visitor implements Runnable{
        BlockingQueue<String> queue;

        public Visitor(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " entered cafe");
                Thread.sleep(1000);
                String pizza = queue.take();
                System.out.println(Thread.currentThread().getName() + " is eating " + pizza);
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " leaved cafe");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Chef implements Runnable{
        BlockingQueue<String> queue;

        public Chef(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String[] pizzas = {"Margarita", "4 Cheese", "Pepperoni", "Diablo", "Spicy", "With Pork", "Vegetarian"};
                    String pizza = pizzas[new Random().nextInt(pizzas.length)];
                    System.out.println(Thread.currentThread().getName() + " is cooking " + pizza);
                    Thread.sleep(1000);
                    queue.put(pizza);
                    System.out.println(Thread.currentThread().getName() + " : " + pizza + " is ready!");
                    if (queue.size() == 3) {
                        System.out.println(Thread.currentThread().getName() + " : Relax!!!");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
