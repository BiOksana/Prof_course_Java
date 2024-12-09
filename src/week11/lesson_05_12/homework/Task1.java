package week11.lesson_05_12.homework;

import java.util.List;
import java.util.regex.Pattern;

public class Task1 {

    public static void main(String[] args) {

//     1) Напишите регулярное выражение, которое соответствует любому номеру телефона согласно формату:
// телефонный номер состоит из 7 цифр подряд или из 3х цифр, пробела или тире, а затем из 4 цифр (1234567, 123-4567, 123 4567).

        String regex = "(\\d{7})|(\\d{3}[ -]\\d{4})";
        System.out.println(Pattern.matches(regex, "1234567"));
        System.out.println(Pattern.matches(regex, "123 4567"));
        System.out.println(Pattern.matches(regex, "123-4567"));

//2) Напишите метод валидации введенного пользователем адреcа электронной почты.
        String nameOfEmail = "shayonda_77@hotmail.com";
        System.out.println(isValidEmail(nameOfEmail));

        nameOfEmail = "carey.kuvalis@yahoo.com";
        System.out.println(isValidEmail(nameOfEmail));

        nameOfEmail = "1627384@@gmail.com";
        System.out.println(isValidEmail(nameOfEmail));


//5) From SummarySession: Напишите метод проверки введенного пароля. Пароль должен иметь от 8 до 15 символов, обязательно содержать цифры,
//буквы верхнего и нижнего регистра и спецсимволы: ~!#$/\-_.

        String password = "Dev#Java#2024";
        System.out.println("checkPassword(password) = " + isValidPassword(password));
        password = "A1b2c3d~";
        System.out.println("checkPassword(password) = " + isValidPassword(password));
        password = "24AbCd.#hwhf111";
        System.out.println("checkPassword(password) = " + isValidPassword(password));
        password = "123456789";
        System.out.println("checkPassword(password) = " + isValidPassword(password));

    }

    private static boolean isValidEmail(String emailName) {
        if (emailName == null) {
            return false;
        }
        String regex = "[\\w.]+@[a-zA-Z]+\\.[a-zA-Z]{2,3}";
        return Pattern.matches(regex, emailName);
    }

    private static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8 || password.length() > 15) {
            return false;
        }

        String regex1 = "\\d+";
        String regex2 = "[a-z]+";
        String regex3 = "[A-Z]+";
        String regex4 = "[~!#$/\\-_.]+";

        List<String> regexList = List.of(regex1, regex2, regex3, regex4);

        int index = 0;
        boolean isValidPart = containsSymbol(regexList.get(index++), password);
        while (index < regexList.size() && isValidPart) {
            isValidPart = containsSymbol(regexList.get(index++), password);
        }
        return isValidPart;
    }

    private static boolean containsSymbol(String regex, String wordToCheck) {
        return Pattern.compile(regex).matcher(wordToCheck).find();
    }
}
