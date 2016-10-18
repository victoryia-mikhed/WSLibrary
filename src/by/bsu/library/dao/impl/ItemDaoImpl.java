package by.bsu.library.dao.impl;


import by.bsu.library.dao.ItemDao;
import by.bsu.library.dao.exception.DaoException;
import by.bsu.library.entity.ItemInfo;

public class ItemDaoImpl implements ItemDao{
    @Override
    public Integer insert(ItemInfo object) throws DaoException {
        return null;
    }

    @Override
    public boolean update(ItemInfo object) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    public ItemInfo getElementById(Integer id) throws DaoException {
        return null;
    }

    @Override
    public boolean takeItem(Integer id) throws DaoException {
        return false;
    }

    @Override
    public boolean returnItem(Integer id) throws DaoException {
        return false;
    }
}
