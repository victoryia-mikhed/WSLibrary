package by.bsu.library.entity;

import java.sql.Date;

public class TakenBookInfo {

    private int itemID;
    private int readerID;
    private String author;
    private String title;
    private Date returnDate;

    public TakenBookInfo() {

    }

    public TakenBookInfo(int itemID, int readerID, String author, String title, Date returnDate) {
        this.itemID = itemID;
        this.readerID = readerID;
        this.author = author;
        this.title = title;
        this.returnDate = returnDate;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getReaderID() {
        return readerID;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
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

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "TakenBookInfo{" +
                "itemID=" + itemID +
                ", readerID=" + readerID +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", returnDate=" + returnDate +
                '}';
    }
}
