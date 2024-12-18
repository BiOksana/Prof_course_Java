package week13.lesson_17_12.homework;

public class MultithreadingHomework {

    static int count1;
    static int count2;
    static int count3;

    public static void main(String[] args) {
//        посчитать количество целых чисел в диапазоне от Integer.MINVALUE до Integer.MAXVALUE,
//которые делятся на заданное целое число без остатка.
//Решить данную задачу последовательно и параллельно в нескольких потоках. Сравнить время выполнения.

        int number = 5;

        long start = System.currentTimeMillis();
        int count = 0;//getCountOfFigureDivisibleByNumberBySequentialExecution(number);
        long end = System.currentTimeMillis();
        System.out.println("Sequential execution time = " + (end - start));     //   -> 19060
        System.out.println("Total divisible by " + number + ":" + count);       //   -> 858993459

        start = System.currentTimeMillis();
//        count = getCountOfFigureDivisibleByNumberByParallelExecution(number); // -> 3 Threads:  14199 & 858993459
        count = getCountOfFigureDivisibleByNumberByParallelExecutionWithRunnableTask(number); // 4 Threads: -> 8018 & 858993459
        end = System.currentTimeMillis();
        System.out.println("Parallel execution time = " + (end - start));     //
        System.out.println("Total divisible by " + number + ":" + count);
    }

    private static int getCountOfFigureDivisibleByNumberByParallelExecutionWithRunnableTask(int number) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int max1 = min / 2;
        int max2 = 0;
        int max3 = max / 2;
        Task task1 = new Task(min, max1, number);
        Task task2 = new Task(max1, max2, number);
        Task task3 = new Task(max2, max3, number);
        Task task4 = new Task(max3, max, number);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
        Thread thread4 = new Thread(task4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            int count1 = task1.getCount();
            thread2.join();
            int count2 = task2.getCount();
            thread3.join();
            int count3 = task3.getCount();
            thread4.join();
            int count4 = task4.getCount();
            return count1 + count2 + count3 + count4;
        } catch (InterruptedException e) {
            throw new RuntimeException("Error");
        }
    }

    private static int getCountOfFigureDivisibleByNumberByParallelExecution(int number) {
        int max1 = (Integer.MAX_VALUE - Integer.MIN_VALUE) / 2;
        int max2 = (Integer.MAX_VALUE - max1) / 2;
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = Integer.MIN_VALUE; i < max1; i++) {
                    if (i % number == 0) {
                        count1++;
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = max1; i < max2; i++) {
                    if (i % number == 0) {
                        count2++;
                    }
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = max2; i < Integer.MAX_VALUE; i++) {
                    if (i % number == 0) {
                        count3++;
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count1 + count2 + count3;
    }

    private static int getCountOfFigureDivisibleByNumberBySequentialExecution(int number) {
        int count = 0;
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            if (i % number == 0) {
                count++;
            }
        }
        return count;
    }

    private static class Task implements Runnable {

        int givenNumber;
        int minNum;

        int maxNum;
        int count;

        public Task(int minNum, int maxNum, int givenNumber) {
            this.minNum = minNum;
            this.maxNum = maxNum;
            this.givenNumber = givenNumber;
        }

        public int getCount() {
            return count;
        }

        @Override
        public void run() {
            for (int i = minNum; i < maxNum; i++) {
                if (i % givenNumber == 0) {
                    count++;
                }
            }
        }
    }
}


