package by.bsu.library.controller;

import by.bsu.library.entity.Reader;
import by.bsu.library.service.BookService;
import by.bsu.library.service.ItemService;
import by.bsu.library.service.ReaderService;
import by.bsu.library.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BooksController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ReaderService readerService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String books(Model model) throws ServiceException {



        //model.addAttribute("reader", reader);
        //model.addAttribute("takenBooks", itemService.getTakenBooksByReaderId(reader.getReaderID()));
        return "main";
    }

}
