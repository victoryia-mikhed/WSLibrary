package by.bsu.library.ws.impl;

import by.bsu.library.entity.Reader;
import by.bsu.library.service.ReaderService;
import by.bsu.library.service.exception.ServiceException;
import by.bsu.library.ws.ReaderWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@WebService
@Component
public class ReaderWSImpl implements ReaderWS{

    @Autowired
    private ReaderService readerService;

    @Override
    public Long insert(Reader object) throws ServiceException {
        return readerService.insert(object);
    }

    @Override
    public boolean update(Reader object) throws ServiceException {
        return readerService.update(object);
    }

    @Override
    public boolean delete(Long id) throws ServiceException {
        return readerService.delete(id);
    }

    @Override
    public Reader getElementById(Long id) throws ServiceException {
        return readerService.getElementById(id);
    }

    @Override
    public Reader getReaderByName(String name) throws ServiceException {
        return getReaderByName(name);
    }

    @Override
    public Reader getReaderByNamePassword(String name, String password) throws ServiceException {
        return readerService.getReaderByNamePassword(name, password);
    }
}
