package by.bsu.library.dao;


import by.bsu.library.dao.exception.DaoException;
import by.bsu.library.entity.Book;

public interface BookDao extends Dao<Book>{

    int searchBook (String bookTitle, String author) throws DaoException;  //returns id of free item

}
