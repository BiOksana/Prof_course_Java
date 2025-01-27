package week16.summarysession;

import java.util.ArrayList;
import java.util.List;

public class LibraryApp {
    public static void main(String[] args) {
//        Book book = new Book("Garry Potter", "hndlw", "nw", 2);
//        User user = new User("Tim", 2);
//        Library library = new Library();
//        LibraryManager libraryManager = new LibraryManager(library);
//        libraryManager.registerUser(user);


        Book book1 = new Book("Harry Potter 3", "Rawling", "B20", 5);
        Book book2 = new Book("Harry Potter 1", "Rawling", "F17", 2);
        Book book3 = new Book("Harry Potter 5", "Rawling", "D21", 4);
        Book book4 = new Book("Tom Sawyer", "M. Twain", "Z43", 1);
        Book book5 = new Book("Peace", "L. Tolstoy", "K65", 1);
        Book book6 = new Book("Algorithms", "Sedgewik", "W5", 2);
        Book book7 = new Book("Java in Action", "R.G. Urma", "H15", 1);
        Book book8 = new Book("Clean Code", "R. Martin", "S3", 2);
        Book book9 = new Book("Harry Potter 2", "Rawling", "N11", 0);
        Book book10 = new Book("Harry Potter", "Rawling", "M51", 3);
        List<Book> books = new ArrayList<>(List.of(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10));

        User user = new User("Tim", 2);

        User user1 = new User("Jim", 5);
        User user2 = new User("Brad", 3);
        User user3 = new User("Kai", 1);
        List<User> users = new ArrayList<>(List.of(user1, user2, user3));

        Library library = new Library(books, users);
        LibraryManager libraryManager = new LibraryManager(library);
//        libraryManager.borrowBook("F17", user);

        library.getUsers().forEach(System.out::println);
        libraryManager.borrowBook("F17", user1);
        libraryManager.borrowBook("F17", user2);
        library.getUsers().forEach(System.out::println);

        libraryManager.borrowBook("N11", user2);
        libraryManager.addBook(book9);

//        libraryManager.removeBook(book9);
        library.getBooks().forEach(System.out::println);


        libraryManager.borrowBook("N11", user);
        libraryManager.borrowBook("W5", user);
        libraryManager.borrowBook("M51", user);

        System.out.println("book10.getAvailableCopies() = " + book10.getAvailableCopies());


        libraryManager.returnBook("M51", user);
        System.out.println("book10.getAvailableCopies() = " + book10.getAvailableCopies());
        library.getUsers().forEach(System.out::println);

        libraryManager.addBook(book9);
        library.getBooks().forEach(System.out::println);

        libraryManager.registerUser(user);
        library.getUsers().forEach(System.out::println);
    }
}
