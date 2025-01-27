package week16.summarysession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryManagerTest {

    LibraryManager libraryManager;
    Library library;
    Book book;
    User user;


    @BeforeEach
    void setUp() {
        library = new Library();
        libraryManager = new LibraryManager(library);
        book = new Book("Harry Potter 3", "Rawling", "B20", 5);
        user = new User("Tim", 2);
    }

    @Test
    void borrowBook() {
        libraryManager.addBook(book);
        libraryManager.registerUser(user);
        libraryManager.borrowBook("B20", user);
        assertEquals(1, user.getBorrowedBooks().size());
    }

    @Test
    void borrowBookWhenUserNotExists() {
        assertEquals(0, libraryManager.getLibrary().getUsers().size());
        int availableCopies = book.getAvailableCopies();
        libraryManager.addBook(book);
        libraryManager.borrowBook("B20", user);
        assertEquals(availableCopies - 1, book.getAvailableCopies());
        assertEquals(1, user.getBorrowedBooks().size());
        assertEquals(book, user.getBorrowedBooks().get(0));
        assertEquals(1, libraryManager.getLibrary().getUsers().size());
    }

    @Test
    void borrowBookWhenBookNotExists() {
        libraryManager.borrowBook("B20", user);
        assertEquals(0, libraryManager.getLibrary().getBooks().size());
    }

    @Test
    void borrowBookWhenAvailableCopiesIs0() {
        Book book1 = new Book("Harry Potter 2", "Rawling", "N11", 0);
        libraryManager.addBook(book1);
        libraryManager.registerUser(user);
        libraryManager.borrowBook("N11", user);
        assertEquals(0, user.getBorrowedBooks().size());
    }

    @Test
    void returnBook() {
        libraryManager.addBook(book);
        int availableCopies = book.getAvailableCopies();
        assertEquals(5, availableCopies);
        libraryManager.registerUser(user);
        libraryManager.borrowBook("B20", user);
        assertEquals(4, availableCopies - 1);
        assertEquals(1, user.getBorrowedBooks().size());
        libraryManager.returnBook("B20", user);
        assertEquals(5, book.getAvailableCopies());
        assertEquals(0, user.getBorrowedBooks().size());
    }

    @Test
    void addBook() {
        libraryManager.addBook(book);
        assertEquals(1, libraryManager.getLibrary().getBooks().size());
    }

    @Test
    void addBookWhenBookAlreadyExists() {
        libraryManager.addBook(book);
        assertEquals(1, libraryManager.getLibrary().getBooks().size());
        libraryManager.addBook(book);
        assertEquals(1, libraryManager.getLibrary().getBooks().size());
    }

    @Test
    void removeBook() {
        libraryManager.addBook(book);
//        book = null;  // must provide null
        assertEquals(1, libraryManager.getLibrary().getBooks().size());
        Book book1 = new Book("Harry Potter 2", "Rawling", "N11", 0);
        libraryManager.addBook(book1);
        assertEquals(2, libraryManager.getLibrary().getBooks().size());
        libraryManager.removeBook(book);
        assertEquals(1, libraryManager.getLibrary().getBooks().size());
        libraryManager.removeBook(book1);
        assertEquals(0, libraryManager.getLibrary().getBooks().size());
    }

    @Test
    void registerUser() {
        libraryManager.registerUser(user);
        assertEquals(1, libraryManager.getLibrary().getUsers().size());
    }

    @Test
    void registerUserWhenSuchUserAlreadyExists() {
        libraryManager.registerUser(user);
        assertEquals(1, libraryManager.getLibrary().getUsers().size());
        libraryManager.registerUser(user);
        assertEquals(1, libraryManager.getLibrary().getUsers().size());
    }
}