package week14.lesson_09_01_25.homework;

import java.util.Iterator;

public class UseCustomDynamicArray {
    public static void main(String[] args) {
        CustomDynamicArray customDynamicArray = new CustomDynamicArray();

        Thread thread1 = new Thread(() -> {
            if (customDynamicArray.isEmpty()) {
            for (int i = 0; i < 100; i++) {
                customDynamicArray.add(i + 1);
            }
            }
        });

        Thread thread11 = new Thread(() -> {
            try {
                thread1.join();
                customDynamicArray.addAt(49, 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
                customDynamicArray.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread21 = new Thread(() -> {
            try {
                thread1.join();
                customDynamicArray.removeAt(34);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                thread1.join();
                customDynamicArray.set(customDynamicArray.contains(60), 120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                thread1.join();
                for (int i = 0; i < 50; i++) {
                    System.out.println(customDynamicArray.get(i));
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread5 = new Thread(() -> {
            try {
                thread1.join();
                Iterator<Integer> iterator = customDynamicArray.iterator();
                while (iterator.hasNext()) {
                    System.out.println(Thread.currentThread().getName() + " " + iterator.next());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread11.start();
        thread2.start();
        thread21.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread11.join();
            thread2.join();
            thread21.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(customDynamicArray);
    }
}
