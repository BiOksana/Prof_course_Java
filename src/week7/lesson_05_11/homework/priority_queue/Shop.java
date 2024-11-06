package week7.lesson_05_11.homework.priority_queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Shop {
// С помощью PriorityQueue реализовать модель: в магазин завозятся товары с двух разных складов. У каждого товара есть
// название и цена. В магазин приходят покупатели и покупают самый дешевый товар.

    public static void main(String[] args) {
        Queue<Good> goodQueue = new PriorityQueue<>();
        Warehouse warehouse1 = new Warehouse(goodQueue);
        Warehouse warehouse2 = new Warehouse(goodQueue);
        Consumer consumer1 = new Consumer(goodQueue);
        Consumer consumer2 = new Consumer(goodQueue);
        Consumer consumer3 = new Consumer(goodQueue);
        Consumer consumer4 = new Consumer(goodQueue);

        for (int i = 0; i < 10; i++) {
            warehouse1.deliverGoods();
            warehouse2.deliverGoods();
        }
        warehouse1.deliverGoods();

        System.out.println("goodQueue.size() = " + goodQueue.size());
        for (Good good : goodQueue) {
            System.out.println(good);
        }

        while (!goodQueue.isEmpty()) {
            consumer1.buyGoods();
            consumer2.buyGoods();
            consumer3.buyGoods();
            consumer4.buyGoods();
        }

    }

    public static class Warehouse {
        private Queue<Good> goodQueue;

        public Warehouse(Queue<Good> goodQueue) {
            this.goodQueue = goodQueue;
        }

        public void deliverGoods() {
            int randomPrice = (int) (Math.random() * 1000);
            Good good = new Good("Good" + randomPrice, randomPrice);
            System.out.println("Good: " + good + " delivered to the store by " + this);
            goodQueue.add(good);
        }
    }

    public static class Consumer {
        private Queue<Good> goodQueue;

        public Consumer(Queue<Good> goodQueue) {
            this.goodQueue = goodQueue;
        }

        public void buyGoods() {
            if (!goodQueue.isEmpty()) {
                Good good = goodQueue.remove();
                System.out.println("Good: " + good + " have been purchased by " + this);
            } else {
                System.out.println("No goods in the shop");
            }
        }
    }
}
