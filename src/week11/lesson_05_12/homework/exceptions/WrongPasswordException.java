package week11.lesson_05_12.homework.exceptions;

public class WrongPasswordException extends Exception{
    public WrongPasswordException() {
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
