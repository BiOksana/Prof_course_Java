package week11.summarysession_06_12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    public static void main(String[] args) {
        String s = "Php is the best programming language in the world. I study php.";

        String regex = "\\bphp\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        String result = matcher.replaceAll("java");

        System.out.println(result);

        //2) Разбить текст на список отдельных строк этого текста.
        s = "Php is the best\nprogramming language in the world.\n I study php.\n";
        String[] strArray = s.split("\\n");

        System.out.println(Arrays.toString(strArray));
        for (String s1 : strArray) {
            System.out.println(s1);
        }

        //3) Напишите метод поиска в тексте всех слов, начинающихся с определенной буквы.
        String novel = "It is a truth universally acknowledged,that a single man in possession of a good fortune," +
                "must be in want of a wife.However little known the feelings or views of such a man may be on his first entering a neighbourhood," +
                "this truth is so well fixed in the minds of the surrounding families,that he is considered the rightful property of some one or other" +
                " of their daughters.";
        System.out.println(searchWords(novel, "a"));


        //4) Имеется текст с логинами и паролями. Найти в тексте выражения вида "login: admin, password: sKb122",
//составить из них Map<login, password>
        System.out.println("Task 4");
        s = "It is a truth universally login: admin, password: sKb122 acknowledged,that a single man in possession of a good fortune," +
                "must be in want of a wife.However little Wnown the feelings or views login: java, password: dhfj56 of such a man may be on his first entering a neighbourhood," +
                "this truth is so well fixed in the minds of the surrounding families,that he is considered the rightful property of some one or other" +
                " of their daughters.";;

                Map<String, String> map = new HashMap<>();
        regex = "login: ([a-zA-Z0-9]+), password: ([a-zA-Z0-9]+)";

        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(s);

        matcher.results()
                .forEach(r -> map.put(r.group(1), r.group(2)));

        System.out.println(map);

//5) Напишите метод проверки введенного пароля. Пароль должен иметь от 8 до 15 символов, обязательно содержать цифры,
//буквы верхнего и нижнего регистра и спецсимволы: ~!#$/\-_.


    }

    private static List<String> searchWords(String novel, String letter) {
        String regex = "\\b"+letter+"[a-zA-Z]*\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(novel);

        return matcher.results()
                .map(r -> r.group())
                .toList();
    }
}
