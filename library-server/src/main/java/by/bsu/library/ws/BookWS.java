package by.bsu.library.ws;

import by.bsu.library.entity.Book;
import by.bsu.library.service.exception.ServiceException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BookWS {

    @WebMethod
    Long insert(Book object) throws ServiceException;

    @WebMethod
    boolean update(Book object) throws ServiceException;

    @WebMethod
    boolean delete(Long id) throws ServiceException;

    @WebMethod
    Book getElementById(Long id) throws ServiceException;

    @WebMethod
    List<Book> getBooksByTitle(String title) throws ServiceException;

    @WebMethod
    List<Book> getBooksByAuthor(String author) throws ServiceException;

    @WebMethod
    List<Book> getAllBooks () throws ServiceException;

}
