package week13.summarysession;

public class Task2 {

    public static int count = 0;

    public static void main(String[] args) {

//2. Имеется общий счет. Два пользователя раз в 1 сек. кладут 10 $ на этот счет. Реализовать потокобезопасным способом.

        new Thread(() -> {
            while (true) {
                synchronized (Task2.class) {
                    if (count == 100) {
                        break;
                    }
                    count += 10;
                    System.out.println("User1 " + count);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (Task2.class) {
                    if (count == 100) {
                        break;
                    }
                    count += 10;
                    System.out.println("User2 " + count);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
}
