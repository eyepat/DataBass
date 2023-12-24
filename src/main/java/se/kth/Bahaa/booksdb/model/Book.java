package se.kth.Bahaa.booksdb.model;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a book.
 * 
 * @author anderslm@kth.se
 */
public class Book {
    
    private int bookId;
    private String isbn; // should check format
    private String title;
    private Date published;
    private String storyLine = "";
    private List<Author> authors; // Lägg till en lista av författare
    // TODO: 
    // Add authors, as a separate class(!), and corresponding methods, to your implementation
    // as well, i.e. "private ArrayList<Author> authors;"
    
    public Book(int bookId, String isbn, String title, Date published) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.published = published;
        this.authors = new ArrayList<>();
    }
    
    public Book(String isbn, String title, Date published) {
        this(-1, isbn, title, published);
        this.authors = new ArrayList<>();
    }
    
    public int getBookId() { return bookId; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public Date getPublished() { return published; }
    public String getStoryLine() { return storyLine; }
    public List<Author> getAuthors() { return authors; } // Getter för författare
    public void setStoryLine(String storyLine) {
        this.storyLine = storyLine;
    }
    // Metoder för att hantera författarlista


    public void addAuthor(Author author) {
        if (!authors.contains(author)) {
            authors.add(author);
        }
    }
    public void removeAuthor(Author author) {
        authors.remove(author);
    }


    @Override
    public String toString() {
        String authorNames = authors.stream()
                .map(Author::getName)
                .reduce("", (a, b) -> a + ", " + b);
        return title + ", " + isbn + ", " + published.toString() + ", Authors: " + authorNames;
    }
}
