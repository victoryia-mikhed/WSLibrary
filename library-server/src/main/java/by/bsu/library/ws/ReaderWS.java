package by.bsu.library.ws;

import by.bsu.library.entity.Reader;
import by.bsu.library.service.exception.ServiceException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ReaderWS {

    @WebMethod
    Long insert(Reader object) throws ServiceException;

    @WebMethod
    boolean update(Reader object) throws ServiceException;

    @WebMethod
    boolean delete(Long id) throws ServiceException;

    @WebMethod
    Reader getElementById(Long id) throws ServiceException;

    @WebMethod
    Reader getReaderByName(String name) throws ServiceException;

    @WebMethod
    Reader getReaderByNamePassword(String name, String password) throws ServiceException;

}
