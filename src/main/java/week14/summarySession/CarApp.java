package week14.summarySession;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CarApp {
//    //    1. Реализовать модель конвейера
////первый поток производит корпус автомобиля ----> класс CarBody
////второй поток производит колеса ----> класс Wheel
////третий поток собирает из 4 колес и одного корпуса автомобиля готовый автомобиль ----> класс Car
    private static BlockingQueue<Car> queueCar = new ArrayBlockingQueue<>(10);
    private static BlockingQueue<CarBody> queueCarBody = new ArrayBlockingQueue<>(10);
    private static BlockingQueue<Wheel> queueWheel = new ArrayBlockingQueue<>(40);

    public static void main(String[] args) {


        new Thread(() -> {
            int index = 1;
            while (true) {
                CarBody carBody = new CarBody();
                try {
                    Thread.sleep(5000);
                    queueCarBody.put(carBody);
                    System.out.println(Thread.currentThread().getName() + " create CarBody " + index++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            int index = 1;
            while (true) {
                Wheel wheel = new Wheel();
                try {
                    Thread.sleep(1000);
                    queueWheel.put(wheel);
                    System.out.println(Thread.currentThread().getName() + " create Wheel " + index++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            int index = 1;
            while (true) {
                try {
                    CarBody carBody = queueCarBody.take();
                    Wheel[] wheels = new Wheel[4];
                    for (int i = 0; i < wheels.length; i++) {
                        wheels[i] = queueWheel.take();
                    }
                    Car car = new Car(carBody, wheels);
                    Thread.sleep(7000);
                    queueCar.put(car);
                    System.out.println(Thread.currentThread().getName() + " created Car " + index++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
}
