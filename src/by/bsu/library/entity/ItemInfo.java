package by.bsu.library.entity;

public class ItemInfo {

    private int itemID;
    private int bookID;
    private String bookAuthor;
    private String bookTitle;

    public ItemInfo() {
    }

    public ItemInfo(int itemID, int bookID, String bookAuthor, String bookTitle) {
        this.itemID = itemID;
        this.bookID = bookID;
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                "itemID=" + itemID +
                ", bookID=" + bookID +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }
}
