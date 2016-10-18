package by.bsu.library.dao.impl;


import by.bsu.library.connect.ConnectionPool;
import by.bsu.library.connect.exception.ConnectionPoolException;
import by.bsu.library.connect.ProxyConnection;
import by.bsu.library.dao.ReaderDao;
import by.bsu.library.dao.exception.DaoException;
import by.bsu.library.entity.Reader;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderDaoImpl implements ReaderDao{

    private static final String SQL_INSERT_READER = "INSERT INTO READERS (NAME, PASSWORD) VALUES (?,MD5(?))";
    private static final String SQL_UPDATE_READER = "UPDATE READERS SET NAME=?, PASSWORD=? WHERE READER_ID=?";
    private static final String SQL_DELETE_READER = "DELETE FROM READERS WHERE READER_ID=?";
    private static final String SQL_SELECT_READER_BY_ID = "SELECT READER_ID, NAME, PASSWORD FROM READERS WHERE READER_ID=?";

    @Override
    public Integer insert(Reader reader) throws DaoException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
        } catch (ConnectionPoolException e) {
            throw new DaoException(e);
        }
        ResultSet resultSet;
        try (PreparedStatement ps = connection.prepareStatement(SQL_INSERT_READER, new String[] {"READER_ID"})) {
            ps.setString(1, reader.getName());
            ps.setString(2, reader.getPassword());
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
    public boolean update(Reader reader) throws DaoException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
        } catch (ConnectionPoolException e) {
            throw new DaoException("Exception in method update", e);
        }
        try (PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_READER)) {
            ps.setString(1, reader.getName());
            ps.setString(2, reader.getPassword());
            ps.setInt(3, reader.getReaderID());
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
        try (PreparedStatement ps = connection.prepareStatement(SQL_DELETE_READER)) {
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
    public Reader getElementById(Integer id) throws DaoException {
        return null;
    }

    @Override
    public boolean takeCurrentPassword(Integer readerID) throws DaoException {
        return false;
    }

    @Override
    public boolean changePassword(Integer readerID, String password) throws DaoException {
        return false;
    }
}
