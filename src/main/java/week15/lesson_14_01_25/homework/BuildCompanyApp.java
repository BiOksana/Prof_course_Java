package week15.lesson_14_01_25.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class BuildCompanyApp {
    // 1 уровень сложности: 1. Строительная фирма:
    //- имеет 4 бригады, каждая бригада строит 1 дом;
    //- фирма строит поселок из 10 домов;
    //- затем принимает отчет от строителей о расходах и вычисляет суммарные расходы за строительство поселка;
    //- после чего принимается за следующий поселок из 10 домов.
    //Реализовать логику с помощью ExecutorService. Каждая бригада - это отдельный поток внутри Executor.
    //Как нужно будет поменять код, если у фирмы:
    //а) Строительство будет вести только одна постоянная бригада? : newSingleThreadExecutor()
    //б) Бригады будут создаваться по количеству стоящихся домов, а после распускаться? newCachedThreadPool()
    final static int QUANTITY_OF_HOUSES = 10;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4); //.newSingleThreadExecutor(); //.newCachedThreadPool(); //
        int counter = 0;

        while (counter++ < 3) {
            List<Future<Integer>> billsFromConstructionTeams = new ArrayList<>(QUANTITY_OF_HOUSES);
            long before = System.nanoTime();
            for (int i = 0; i < QUANTITY_OF_HOUSES; i++) {
                billsFromConstructionTeams.add(service.submit(new ConstructionTeam(i + 1)));
            }
            long after = System.nanoTime();


            Integer totalBill = billsFromConstructionTeams.stream().map(f -> {
                try {
                    return f.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }).reduce(0, Integer::sum);


            System.out.println("\n\n----------------------------------------");
            System.out.println("Total estimate = " + totalBill + "; execution time = " + (after - before));
            System.out.println("----------------------------------------\n\n");
        }

        service.shutdown();
    }

    static class ConstructionTeam implements Callable<Integer> {
        int estimate;
        int houseNumber;

        public ConstructionTeam(int houseNumber) {
            this.houseNumber = houseNumber;
        }

        @Override
        public Integer call() {
            System.out.println(Thread.currentThread().getName() + " is building house " + houseNumber);
            estimate = new Random().nextInt(30000, 50000);
            try {
                Thread.sleep(new Random().nextInt(1000, 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished to build house " + houseNumber);
            System.out.println("Bill to pay : " + estimate);
            return estimate;
        }
    }
}
