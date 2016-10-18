package by.bsu.library.dao;


import by.bsu.library.dao.exception.DaoException;
import by.bsu.library.entity.ItemInfo;

public interface ItemDao extends Dao<ItemInfo> {

    boolean takeItem(Integer id) throws DaoException;

    boolean returnItem(Integer id) throws DaoException;

}
