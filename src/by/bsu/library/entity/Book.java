package by.bsu.library.entity;


public class Book {

    private int bookID;
    private String author;
    private String title;
    private int amount;

    public Book() {

    }

    public Book(int bookID, String author, String title, int amount) {
        this.bookID = bookID;
        this.author = author;
        this.title = title;
        this.amount = amount;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", amount=" + amount +
                '}';
    }
}
