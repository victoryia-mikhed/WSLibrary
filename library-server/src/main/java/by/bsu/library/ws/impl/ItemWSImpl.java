package by.bsu.library.ws.impl;

import by.bsu.library.entity.ItemInfo;
import by.bsu.library.entity.TakenBookInfo;
import by.bsu.library.service.ItemService;
import by.bsu.library.service.ReaderService;
import by.bsu.library.service.exception.ServiceException;
import by.bsu.library.ws.ItemWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

@WebService
@Component
public class ItemWSImpl implements ItemWS{

    @Autowired
    private ItemService itemService;


    @Override
    public Long insert(ItemInfo object) throws ServiceException {
        return itemService.insert(object);
    }

    @Override
    public boolean update(ItemInfo object) throws ServiceException {
        return itemService.update(object);
    }

    @Override
    public boolean delete(Long id) throws ServiceException {
        return itemService.delete(id);
    }

    @Override
    public ItemInfo getElementById(Long id) throws ServiceException {
        return itemService.getElementById(id);
    }

    @Override
    public int getItemsCountByBookId(Long bookID) throws ServiceException {
        return itemService.getItemsCountByBookId(bookID);
    }

    @Override
    public List<ItemInfo> getAllItemsByBookId(Long bookID) throws ServiceException {
        return itemService.getAllItemsByBookId(bookID);
    }

    @Override
    public List<TakenBookInfo> getTakenBooksByReaderId(Long readerID) throws ServiceException {
        return itemService.getTakenBooksByReaderId(readerID);
    }

    @Override
    public List<TakenBookInfo> getExpiredBooksByReaderId(Long readerID) throws ServiceException {
        return itemService.getExpiredBooksByReaderId(readerID);
    }

    @Override
    public boolean takeBook(Long bookID, Long readerID) throws ServiceException {
        return itemService.takeBook(bookID, readerID);
    }

    @Override
    public boolean returnBook(Long itemID) throws ServiceException {
        return itemService.returnBook(itemID);
    }
}
