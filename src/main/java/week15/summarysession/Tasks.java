package week15.summarysession;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tasks {
    /*
    1. Имеется много текстовых файлов большого объема. Реализовать метод поиска заданных слов.
В результате должно выводиться имя файла, номер строки и номер символа начала данного слова.
Сделать вычисления параллельными.
2. Имеется класс lesson20240924.inheritance.Human. Через рефлексию
- вызвать методы introduce(), feedAnimal(Animal animal)
- создать экземпляр класса
3. Имеется класс lesson20241119.hometasks.Jokes. Через рефлексию
заменить список исходных шуток в классе.
     */
    public static void main(String[] args) {

        String path = "src\\main\\resources\\Folder\\Folder1\\Folder2\\Folder3";

        searchWords(path, "elementum").forEach(System.out::println);
    }

    public static ConcurrentLinkedQueue<String> searchWords(String path, String word) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        File file = new File(path);
        File[] files = file.listFiles();
        Arrays.stream(files).parallel().filter(f -> f.getName().endsWith(".txt")).forEach(currentFile -> {

            int numberOfLine = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader(currentFile))) {
                String readerLine = reader.readLine();

                Pattern pattern = Pattern.compile("\\b" + word + "\\b");
                Matcher matcher;
                while (readerLine != null) {
                    matcher = pattern.matcher(readerLine);
                    while (matcher.find()) {
                        queue.add("file name : " + currentFile.getName() + " " + ", numberOfLine : " + numberOfLine++ + " " + ", start: " + matcher.start());
                    }
                    readerLine = reader.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return queue;
    }
}
