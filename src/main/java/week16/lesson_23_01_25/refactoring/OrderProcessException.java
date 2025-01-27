package week16.lesson_23_01_25.refactoring;

public class OrderProcessException extends RuntimeException {
        public OrderProcessException() {
        }

        public OrderProcessException(String message) {
            super(message);
        }

        public OrderProcessException(String message, Throwable cause) {
            super(message, cause);
        }


    }

