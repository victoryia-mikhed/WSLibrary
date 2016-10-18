package by.bsu.library.dao;

import by.bsu.library.dao.exception.DaoException;


public interface Dao<T> {

    Integer insert(T object) throws DaoException;

    boolean update(T object) throws DaoException;

    boolean delete(Integer id) throws DaoException;

    T getElementById(Integer id) throws DaoException;

}
