package week8.lesson_12_11.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TranslatorApp {
    //Создайте программу-переводчик с английского языка. Пользователь вводит слово на английском языке, переводчик показывает перевод.
    // Если переводчик не обнаружил в словаре введённое слово, то он просит пользователя ввести перевод, после чего сохраняет слово и его перевод в словарь.
    public static void main(String[] args) {

        Map<String, String> englishToGerman = new HashMap<>();
        englishToGerman.put("hello", "hallo");
        englishToGerman.put("goodbye", "auf Wiedersehen");
        englishToGerman.put("please", "bitte");
        englishToGerman.put("thank you", "danke");
        englishToGerman.put("yes", "ja");
        englishToGerman.put("no", "nein");
        englishToGerman.put("friend", "freund");
        englishToGerman.put("book", "buch");
        englishToGerman.put("house", "haus");
        englishToGerman.put("car", "auto");
        Translator translator = new Translator(englishToGerman);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word: ");
        String word = scanner.nextLine();

        while (!word.equalsIgnoreCase("stop")) {
            if (translator.isContained(word)) {
                System.out.println(translator.translate(word));
            } else {
                System.out.println("The dictionary does not contain this word. Please enter its translation in German: ");
                String translation = scanner.nextLine();
                translator.addTranslation(word, translation);
            }
            System.out.println("Enter word: ");
            word = scanner.nextLine();
        }
    }
}
