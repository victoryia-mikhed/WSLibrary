package by.bsu.library.entity;

import java.util.ArrayList;
import java.util.List;

public class TakenBooksList {

    private List<TakenBookInfo> takenBooks;

    public TakenBooksList () {
        takenBooks = new ArrayList<>();
    }

    public TakenBooksList(List<TakenBookInfo> takenBooks) {
        this.takenBooks = takenBooks;
    }

    public List<TakenBookInfo> getTakenBooks() {
        return takenBooks;
    }

    public void setTakenBooks(List<TakenBookInfo> takenBooks) {
        this.takenBooks = takenBooks;
    }


}
