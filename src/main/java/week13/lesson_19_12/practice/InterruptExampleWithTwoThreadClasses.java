package week13.lesson_19_12.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InterruptExampleWithTwoThreadClasses {
    static Task1 task1 = new Task1();
    static Task2 task2 = new Task2();

    public static void main(String[] args) {
        task1.start();
        task2.start();
    }

    static class Task1 extends Thread {
        List<Integer> integerList = new ArrayList<>();

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {//
                integerList.add((int) (Math.random() * 1_000_001));
            }
            for (Integer integer : integerList) {
                boolean isPrime = true;
                if (integer < 2) {
                    isPrime = false;
                }
                for (int i = 2; i <= Math.sqrt(integer); i++) {
                    if (integer % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
//                    System.out.println(integer + "  is prime number");
                }
                if (integer > 900000) {
                    task2.interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + " finished work. integerList.size() = " + integerList.size());

        }
    }

    static class Task2 extends Thread {
        List<String> stringList = new ArrayList<>();
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int minLength = 5;
        int maxLength = 15;

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                int length = random.nextInt(maxLength - minLength + 1) + minLength;
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < length; j++) {
                    char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
                    sb.append(randomChar);
                }
                stringList.add(sb.toString());
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("stringList.size() = " + stringList.size());
                    System.out.println("Done!!!");
                    break;
                }
            }

        }
    }
}

