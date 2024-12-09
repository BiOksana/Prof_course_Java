package week11.lesson_05_12.homework;

import week11.lesson_05_12.homework.exceptions.WrongLoginException;
import week11.lesson_05_12.homework.exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class Task3 {

//3) Напишите метод проверки логина и пароля.
//Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
//Login должен содержать только латинские буквы, длина login должна быть от 3 до 20 символов.
//Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
//Password должен содержать только цифры и латинские буквы. Длина password должна быть от 5 до 20 символов.
//Также password и confirmPassword должны быть равны.
//Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
//
//WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по умолчанию,
//второй принимает сообщение исключения и передает его в конструктор класса Exception.
//Обработка исключений проводится внутри метода.
//Используем multi-catch block. Метод возвращает true, если значения верны или false в другом случае.
//Пример вызова метода:
//checkLoginAndPassword(john, 1234a, 1234a) --> true
//checkLoginAndPassword(john, 12345, 123456) --> false
//checkLoginAndPassword(john, 12345@, 12345@) --> false
//checkLoginAndPassword(john1, 12345, 12345) --> false

    public static void main(String[] args) {
        System.out.println(checkLoginAndPassword("john", "1234a", "1234a"));
        System.out.println(checkLoginAndPassword("john", "12345", "123456"));
        System.out.println(checkLoginAndPassword("john", "12345@", "12345@"));
        System.out.println(checkLoginAndPassword("john1", "12345", "12345"));
    }

    private static boolean checkLoginAndPassword(String login, String password, String confirmPassword) {
        String message = "";
        String loginRegex = "[a-z]{3,20}";
        String passwordRegex = "[a-z0-9]{5,20}";
        try {
            if (login == null || login.length() < 3 || login.length() > 20 || !Pattern.matches(loginRegex, login)) {
                throw new WrongLoginException("Login is wrong");
            }
            if (password == null || password.length() < 5 || password.length() > 20
                    || !password.equals(confirmPassword) || !Pattern.matches(passwordRegex, password)) {
                throw new WrongPasswordException("Password is wrong");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
