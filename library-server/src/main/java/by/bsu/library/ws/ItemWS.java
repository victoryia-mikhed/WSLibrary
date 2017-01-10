package by.bsu.library.ws;

import by.bsu.library.entity.ItemInfo;
import by.bsu.library.entity.TakenBookInfo;
import by.bsu.library.service.exception.ServiceException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ItemWS {

    @WebMethod
    Long insert(ItemInfo object) throws ServiceException;

    @WebMethod
    boolean update(ItemInfo object) throws ServiceException;

    @WebMethod
    boolean delete(Long id) throws ServiceException;

    @WebMethod
    ItemInfo getElementById(Long id) throws ServiceException;

    @WebMethod
    int getItemsCountByBookId(Long bookID) throws ServiceException;

    @WebMethod
    List<ItemInfo> getAllItemsByBookId(Long bookID) throws ServiceException;

    @WebMethod
    List<TakenBookInfo> getTakenBooksByReaderId(Long readerID) throws ServiceException;

    @WebMethod
    List<TakenBookInfo> getExpiredBooksByReaderId(Long readerID) throws ServiceException;

    @WebMethod
    boolean takeBook(Long bookID, Long readerID) throws ServiceException;

    @WebMethod
    boolean returnBook(Long itemID) throws ServiceException;

}
