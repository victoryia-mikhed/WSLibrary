package by.bsu.library.controller;

import by.bsu.library.entity.Reader;
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
public class MainPageController {

    @Autowired
    private ReaderService readerService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage(Model model) throws ServiceException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Reader reader = readerService.getReaderByName(name);
        model.addAttribute("reader", reader);
        model.addAttribute("takenBooks", itemService.getTakenBooksByReaderId(reader.getReaderID()));
        return "main";
    }
}
