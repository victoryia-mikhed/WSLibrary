package by.bsu.library.dao;


import by.bsu.library.dao.exception.DaoException;
import by.bsu.library.entity.Reader;

public interface ReaderDao extends Dao<Reader>{

    boolean takeCurrentPassword(Integer readerID) throws DaoException;

    boolean changePassword(Integer readerID, String password) throws DaoException;
}
