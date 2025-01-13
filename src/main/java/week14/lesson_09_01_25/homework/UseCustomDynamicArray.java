package week14.lesson_09_01_25.homework;

public class UseCustomDynamicArray {
    public static void main(String[] args) {
        CustomDynamicArray customDynamicArray = new CustomDynamicArray();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                customDynamicArray.add(i + 1);
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
                for (int i = 0; i < 99; i++) {
                    System.out.println(customDynamicArray.get(i));
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(customDynamicArray);
    }
}
