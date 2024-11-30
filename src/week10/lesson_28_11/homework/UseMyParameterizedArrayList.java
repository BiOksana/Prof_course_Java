package week10.lesson_28_11.homework;

import week6.lesson_29_10.comparator.Book;

import java.util.Iterator;

public class UseMyParameterizedArrayList {
    // Переделать класс MyArrayList (пакет lesson20241017.customiterator) так, чтобы этот класс мог хранить данные любого типа.
    public static void main(String[] args) {
        Book book1 = new Book("Rawling", "Harry Potter 3", 20, true, 15.0);
        Book book2 = new Book("Rawling", "Harry Potter 1", 10, true, 10.0);
        Book book3 = new Book("Rawling", "Harry Potter 5", 10, true, 10.0);
        Book book4 = new Book("M. Twain", "Tom Sawyer", 10, true, 10.0);
        Book book5 = new Book("L. Tolstoy", "Peace", 10, true, 10.0);
        Book book6 = new Book("Sedgewik", "Algorithms", 10, true, 10.0);
        Book book7 = new Book("", "Java in Action", 1, true, 7.0);
        Book book8 = new Book("R. Martin", "Clean Code", 10, true, 10.0);
        Book book9 = new Book("Rawling", "Harry Potter 2", 10, true, 10.0);
        Book book10 = new Book("Rawling", "Harry Potter", 10, true, 10.0);
        Book[] booksArray = {book1, book2, book3, book4, book5, book6, book7, book8, book9, book10};
        MyParameterizedArrayList<Book> books = new MyParameterizedArrayList<>(booksArray);

        books.add(new Book("Robert Sedgewick", "Algorithms", 5, false, 14.0));
        System.out.println("books.getSize() = " + books.getSize());

        System.out.println("Iterator: ");
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("reversedBookIterator: ");
        Iterator<Book> reversedBookIterator = books.reverseIterator();
        while (reversedBookIterator.hasNext()) {
            System.out.println(reversedBookIterator.next());
        }

        System.out.println("randomBookIterator: ");
        Iterator<Book> randomBookIterator = books.randomIterator();
        while (randomBookIterator.hasNext()) {
            System.out.println(randomBookIterator.next());
        }

    }
}
