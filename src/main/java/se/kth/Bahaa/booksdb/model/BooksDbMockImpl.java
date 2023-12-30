/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.Bahaa.booksdb.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A mock implementation of the BooksDBInterface interface to demonstrate how to
 * use it together with the user interface.
 * <p>
 * Your implementation must access a real database.
 *
 * @author anderslm@kth.se
 */
public class BooksDbMockImpl implements BooksDbInterface {

    private final List<Book> books;

    public BooksDbMockImpl() {
        this.books = new ArrayList<>(Arrays.asList(DATA));
    }

    @Override
    public boolean connect(String database) throws BooksDbException {
        // mock implementation
        return true;
    }

    @Override
    public void disconnect() throws BooksDbException {
        // mock implementation
    }

    @Override
    public void addBook(Book book) throws BooksDbException {
        books.add(book);
    }


    @Override
    public void updateBook(Book book) throws BooksDbException {

    }

    @Override
    public void deleteBook(int bookId) throws BooksDbException {

    }

    @Override
    public void deleteAuthor(int authorId) throws BooksDbException {

    }


    @Override
    public List<Book> searchBooksByTitle(String searchTitle)
            throws BooksDbException {
        // mock implementation
        // NB! Your implementation should select the books matching
        // the search string via a query to a database (not load all books from db)
        List<Book> result = new ArrayList<>();
        searchTitle = searchTitle.toLowerCase();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTitle)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public List<Book> searchBooksByAuthor(String authorName) throws BooksDbException {
            List<Book> result = new ArrayList<>();
            authorName = authorName.toLowerCase();
            for (Book book : books) {
                if (book.getAuthorNames().toLowerCase().contains(authorName)) {
                    result.add(book);
                }
            }
            return result;
    }

    @Override
    public  List<Book> searchBookByISBN(String isbn) throws BooksDbException {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                result.add(book);
                return result;
            }
        }
        return result;
    }

    @Override
    public List<Book> searchBooksByGenre(Genre genre) throws BooksDbException {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre() == genre) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public List<Book> searchBooksByRating(int rating) throws BooksDbException {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getRating() == rating) {
                result.add(book);
            }
        }
        return result;
    }


    private static final Book[] DATA = {
            new Book(1, "123456789", "Databases Illuminated", new Date(2018, 1, 1)),
            new Book(2, "234567891", "Dark Databases", new Date(1990, 1, 1)),
            new Book(3, "456789012", "The buried giant", new Date(2000, 1, 1)),
            new Book(4, "567890123", "Never let me go", new Date(2000, 1, 1)),
            new Book(5, "678901234", "The remains of the day", new Date(2000, 1, 1)),
            new Book(6, "234567890", "Alias Grace", new Date(2000, 1, 1)),
            new Book(7, "345678911", "The handmaids tale", new Date(2010, 1, 1)),
            new Book(8, "345678901", "Shuggie Bain", new Date(2020, 1, 1)),
            new Book(9, "345678912", "Microserfs", new Date(2000, 1, 1)),
    };
}
