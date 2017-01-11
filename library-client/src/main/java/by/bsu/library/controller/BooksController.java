package by.bsu.library.controller;

import by.bsu.library.entity.Book;
import by.bsu.library.entity.Reader;
import by.bsu.library.service.BookService;
import by.bsu.library.service.ItemService;
import by.bsu.library.service.ReaderService;
import by.bsu.library.service.exception.ServiceException;
import by.bsu.library.ws.BookWS;
import by.bsu.library.ws.ItemWS;
import by.bsu.library.ws.ReaderWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BooksController {

    @Autowired
    private BookWS bookService;

    @Autowired
    private ReaderWS readerService;

    @Autowired
    private ItemWS itemService;

    @RequestMapping(value = "/library", method = RequestMethod.GET)
    public String library(Model model) throws ServiceException {
        model.addAttribute("allBooks", bookService.getAllBooks());
        return "library";
    }

    @RequestMapping(value = "/books/show/{bookID}", method = RequestMethod.GET)
    public String singleBook(@PathVariable Long bookID, Model model) throws ServiceException {
        model.addAttribute("book", bookService.getElementById(bookID));
        model.addAttribute("countItems", itemService.getItemsCountByBookId(bookID));
        return "book";
    }

    @RequestMapping(value = "/books/take", method = RequestMethod.POST)
    public String takeBook(Model model, @ModelAttribute("book") Book book) throws ServiceException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        itemService.takeBook(book.getBookID(), readerService.getReaderByName(auth.getName()).getReaderID());
        return "redirect:/books";
    }

    @ModelAttribute("book")
    public Book getBook() throws ServiceException {
        return new Book();
    }
}