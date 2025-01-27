package week16.summarysession;

import java.util.Optional;

public class LibraryManager {

    private Library library;

    public LibraryManager(Library library) {
        this.library = library;
    }

    public Library getLibrary() {
        return library;
    }

    public void borrowBook(String isbn, User user) {
        Optional<Book> bookByIsbn = library.findBookByIsbn(isbn);
        if (bookByIsbn.isPresent()) {
            Book book = bookByIsbn.get();
            int availableCopies = book.getAvailableCopies();
            if (availableCopies > 0) {
                if (!library.getUsers().contains(user)) {
                    library.registerUser(user);
                }
                book.setAvailableCopies(availableCopies - 1);
                user.borrowBook(book);
            } else {
                System.out.println("Book isn't available");
            }
        } else {
            System.out.println("Book isn't to be found");
        }
    }

    public void returnBook(String isbn, User user) {
        Optional<Book> bookByIsbn = library.findBookByIsbn(isbn);
        if (bookByIsbn.isPresent()) {
            Book book = bookByIsbn.get();
            if (library.getUsers().contains(user) && user.getBorrowedBooks().contains(book)) {
                book.setAvailableCopies(book.getAvailableCopies() + 1);
                user.returnBook(book);
            } else {
                System.out.println("User hasn't this book");
            }
        } else {
            System.out.println("Book isn't to be found");
        }
    }

    public void addBook(Book book) {
        if (!library.getBooks().contains(book)) {
            library.addBook(book);
        } else {
            System.out.println("Such book already exists");
        }
    }

    public void removeBook(Book book) {
        library.removeBook(book);
    }

    public void registerUser(User user) {
        if (!library.getUsers().contains(user)) {
            library.registerUser(user);
        } else {
            System.out.println("Such user already exists");
        }
    }
}
