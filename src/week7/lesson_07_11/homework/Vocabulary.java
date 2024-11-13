package week7.lesson_07_11.homework;

import java.util.*;

public class Vocabulary {

    public static void main(String[] args) {

        //Имеется некоторый текст. Составить словарь используемых в нем слов с частотой их употребления. Отсортировать словарь по частоте встречаемости слов (по убыванию).
        String text = new String("It is a truth universally acknowledged,that a single man in possession of a good fortune," +
                "must be in want of a wife.However little known the feelings or views of such a man may be on his first entering a neighbourhood," +
                "this truth is so well fixed in the minds of the surrounding families,that he is considered the rightful property of some one or other" +
                " of their daughters.");

        Map<String, Integer> vocabulary = getStringIntegerMap(text);

        sortStringIntegerMapByValue(vocabulary);

        for (Map.Entry<String, Integer> entry : vocabulary.entrySet()) {
            System.out.println(entry);
        }


    }

    private static void sortStringIntegerMapByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        map.clear();
        for (Map.Entry<String, Integer> stringIntegerEntry : entries) {
            map.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
    }

    private static Map<String, Integer> getStringIntegerMap(String text) {
        String[] strings = text.split("[ ,.;:!?-]");
        Map<String, Integer> vocabulary = new LinkedHashMap<>();
        for (String string : strings) {
            vocabulary.put(string.toLowerCase(), vocabulary.getOrDefault(string.toLowerCase(), 0) + 1);
        }
        return vocabulary;
    }
}
