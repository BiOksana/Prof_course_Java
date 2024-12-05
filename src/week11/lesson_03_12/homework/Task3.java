package week11.lesson_03_12.homework;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {
// 3. В некотором методе возникает Exception. Реализовать логирование стектрейса Exception со временем ошибки в файл errors.log.
// Логи всех возникших Exception должны накапливаться в файле, не перезаписываясь при перезапуске программы.
        String error = null;

        try {
            method1();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            error = LocalTime.now() + "_" + e.getClass().getSimpleName() + " : " + e.getMessage() + "\n"
                    + Arrays.toString(stackTrace) + "\n";
        }


        try (FileWriter fileWriter = new FileWriter("Folder/errors.log", true)) {
            fileWriter.write(error);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method1() {
        System.out.println(1 / 0);
    }


}
