package week14.lesson_07_01_25.homework;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class MessageReaderApp {
    /*
    Применить BlockingQueue:
Класс Продьюсер - генерирует сообщения в очередь
Класс Консьюмер - забирает сообщения из очереди
Задача - реализовать класс Consumer, который будет анализировать сообщения в очереди и
при входящем сообщении "exit" заканчивать работу.
При реализации использовать одну из стандартных реализаций BlockingQueue из Java библиотеки
     */
    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        Thread thread = new Thread(new Producer(queue), "Producer");
        thread.setDaemon(true);
        thread.start();
        new Thread(new Consumer(queue), "Consumer").start();

    }

    static class Producer implements Runnable {
        BlockingQueue<String> queue;

        public Producer(BlockingQueue<String> blockingQueue) {
            this.queue = blockingQueue;
        }

        @Override
        public void run() {
            String[] messages = {"Hello!", "Hi!", "How’s it going?", "I’m great", "And you?", "Can’t complain", "exit"};
            while (true) {
                try {
                    String message = messages[new Random().nextInt(messages.length)];
                    System.out.println(Thread.currentThread().getName() + " adds the message : " + message);
                    queue.put(message);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class Consumer implements Runnable {
        BlockingQueue<String> queue;

        public Consumer(BlockingQueue<String> blockingQueue) {
            this.queue = blockingQueue;
        }

        String message = "";

        @Override
        public void run() {
            while (!"exit".equalsIgnoreCase(message)) {
                try {
                    message = queue.take();
                    Thread.sleep(4000);
                    System.out.println(Thread.currentThread().getName() + ": reads the message: " + message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " is terminated");
        }
    }
}
