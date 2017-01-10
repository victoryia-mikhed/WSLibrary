package by.bsu.library.ws.impl;

import by.bsu.library.entity.Book;
import by.bsu.library.service.BookService;
import by.bsu.library.service.exception.ServiceException;
import by.bsu.library.ws.BookWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

@WebService
@Component
public class BookWSImpl implements BookWS{

    @Autowired
    private BookService bookService;


    @Override
    public Long insert(Book object) throws ServiceException {
        return bookService.insert(object);
    }

    @Override
    public boolean update(Book object) throws ServiceException {
        return bookService.update(object);
    }

    @Override
    public boolean delete(Long id) throws ServiceException {
        return bookService.delete(id);
    }

    @Override
    public Book getElementById(Long id) throws ServiceException {
        return bookService.getElementById(id);
    }

    @Override
    public List<Book> getBooksByTitle(String title) throws ServiceException {
        return bookService.getBooksByTitle(title);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) throws ServiceException {
        return bookService.getBooksByAuthor(author);
    }
}
