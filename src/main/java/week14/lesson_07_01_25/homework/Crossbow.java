package week14.lesson_07_01_25.homework;

import java.util.Scanner;

public class Crossbow {
    private int arrows;
    Scanner scanner = new Scanner(System.in);

    public Crossbow() {
        System.out.println("Enter count of arrows: ");
        this.arrows = scanner.nextInt();
    }

    // When the arrows end, the wait() method is called and releases.
    synchronized public void fire() {
        while (true) {
            for (int idx = arrows; idx >= 0; idx--) {

                if (idx != 0) {
                    System.out.println("The arrow is " + (arrows - idx + 1) + " right on the target!");
                } else {
                    System.out.println("The arrows are over");
                    arrows = 0;
                    System.out.println("Count arrows " + arrows);
                    System.out.println("Carry a new quiver with arrows!!");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notify();
        }
    }

    // reload() brings new arrows, calls the notify() method, which awakens the thread
    synchronized public void reload() {
        while (true) {
            System.out.println("New arrows on the way!\nEnter count of arrows to fill quiver: ");
            arrows = scanner.nextInt();
            System.out.println("Count arrows = " + arrows);
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Crossbow crossbow = new Crossbow();

        Thread robinHood = new Thread(crossbow::fire);
        Thread servant = new Thread(crossbow::reload);

        robinHood.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        servant.start();
    }
}
