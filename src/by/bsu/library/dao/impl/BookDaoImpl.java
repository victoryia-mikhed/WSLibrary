package by.bsu.library.dao.impl;


import by.bsu.library.connect.ConnectionPool;
import by.bsu.library.connect.ProxyConnection;
import by.bsu.library.connect.exception.ConnectionPoolException;
import by.bsu.library.dao.BookDao;
import by.bsu.library.dao.exception.DaoException;
import by.bsu.library.entity.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDaoImpl implements BookDao{

    private static final String SQL_INSERT_BOOK = "INSERT INTO BOOKS (AUTHOR, TITLE, AMOUNT) VALUES (?,?,?)";
    private static final String SQL_UPDATE_BOOK = "UPDATE BOOKS SET AUTHOR=?, TITLE=?, AMOUNT=? WHERE BOOK_ID=?";
    private static final String SQL_DELETE_BOOK = "DELETE FROM BOOKS WHERE BOOK_ID=?";
    private static final String SQL_SELECT_BOOK_BY_ID = "SELECT BOOK_ID, AUTHOR, TITLE FROM BOOKS WHERE BOOK_ID=?";
    private static final String SQL_INCREMENT_AMOUNT = "UPDATE BOOKS SET AMOUNT=AMOUNT+1 WHERE BOOK_ID=?";
    private static final String SQL_DECREMENT_AMOUNT = "UPDATE BOOKS SET AMOUNT=AMOUNT-1 WHERE BOOK_ID=?";

    @Override
    public Integer insert(Book book) throws DaoException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
        } catch (ConnectionPoolException e) {
            throw new DaoException("Exception in method insert", e);
        }
        ResultSet resultSet;
        try (PreparedStatement ps = connection.prepareStatement(SQL_INSERT_BOOK, new String[] {"BOOK_ID"})) {
            ps.setString(1, book.getAuthor());
            ps.setString(2, book.getTitle());
            ps.setInt(3, book.getAmount());
            if (ps.executeUpdate() == 0) {
                return null;
            }
            resultSet = ps.getGeneratedKeys();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            connection.close();
        }
    }

    @Override
    public boolean update(Book book) throws DaoException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
        } catch (ConnectionPoolException e) {
            throw new DaoException("Exception in method update", e);
        }
        try (PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_BOOK)) {
            ps.setString(1, book.getAuthor());
            ps.setString(2, book.getTitle());
            ps.setInt(3, book.getBookID());
            if (ps.executeUpdate() == 0) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            connection.close();
        }
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
        } catch (ConnectionPoolException e) {
            throw new DaoException("Exception in method delete", e);
        }
        try (PreparedStatement ps = connection.prepareStatement(SQL_DELETE_BOOK)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() == 0) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            connection.close();
        }
    }

    @Override
    public Book getElementById(Integer id) throws DaoException {
        return null;
    }

    @Override
    public int searchBook(String bookTitle, String author) throws DaoException {
        return 0;
    }
}
