package week16.summarysession;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {

    private List<Book> books;

    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public Library(List<Book> books, List<User> users) {
        this.books = books;
        this.users = users;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public Optional<Book> findBookByIsbn(String isbn) {
        return books.stream()
                .filter(book -> isbn.equals(book.getIsbn()))
                .findAny();
    }
}
