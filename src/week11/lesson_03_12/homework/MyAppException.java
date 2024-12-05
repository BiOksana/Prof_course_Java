package week11.lesson_03_12.homework;

public class MyAppException extends RuntimeException{ // Exception
    public MyAppException() {
    }

    public MyAppException(String message) {
        super(message);
    }
}
