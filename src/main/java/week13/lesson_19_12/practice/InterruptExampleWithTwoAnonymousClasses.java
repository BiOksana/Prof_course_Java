package week13.lesson_19_12.practice;

import java.util.ArrayList;
import java.util.List;

public class InterruptExampleWithTwoAnonymousClasses {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < 1_000_000; i++) {
                integerList.add((int) (Math.random() * 1_000_000));
            }
            for (Integer number : integerList) {
                boolean isPrime = true;
                if (number < 2) {
                    isPrime = false;
                }
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    System.out.println(number + " is prime number");
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Done!!!");
                        break;
                    }
                }

            }
        });

        Thread thread2 = new Thread(() -> {
            List<String> stringList = new ArrayList<>();
            String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int i = 0; i < 1_000_000; i++) {
                int length = (int) (Math.random() * 11 + 5);
                StringBuilder word = new StringBuilder();
                for (int j = 0; j < length; j++) {
                    char ch = alphabet.charAt((int) (Math.random() * alphabet.length()));
                    word.append(ch);
                }
                stringList.add(word.toString());

                if (stringList.size() > 500000) {
                    thread1.interrupt();
                }
            }


        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
