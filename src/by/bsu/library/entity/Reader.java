package by.bsu.library.entity;


public class Reader {

    private int readerID;
    private String name;
    private String password;

    public Reader() {

    }

    public Reader(int readerID, String name, String password) {
        this.readerID = readerID;
        this.name = name;
        this.password = password;
    }

    public int getReaderID() {
        return readerID;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerID=" + readerID +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
