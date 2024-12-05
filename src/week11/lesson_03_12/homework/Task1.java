package week11.lesson_03_12.homework;

import java.io.*;

public class Task1 {
    //  1. Создайте файл с текстом: "This is my first experience when I work with IO API. I can do everything!"
    //Откройте и прочтите файл, напечатав его содержимое в консоль.

    public static void main(String[] args) {
        String filePath = "Folder/fileHW.txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            String text = "This is my first experience when I work with IO API. I can do everything!";
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
