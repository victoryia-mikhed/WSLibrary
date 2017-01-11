package by.bsu.library.controller;

import by.bsu.library.entity.ItemInfo;
import by.bsu.library.entity.Reader;
import by.bsu.library.entity.TakenBookInfo;
import by.bsu.library.service.exception.ServiceException;
import by.bsu.library.ws.ItemWS;
import by.bsu.library.ws.ReaderWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private ReaderWS readerService;

    @Autowired
    private ItemWS itemService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String profile(Model model) throws ServiceException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Reader reader = readerService.getReaderByName(name);
        model.addAttribute("reader", reader);
        model.addAttribute("takenBooks", itemService.getTakenBooksByReaderId(reader.getReaderID()));
        return "main";
    }


    @RequestMapping(value = "/books/return", method = RequestMethod.POST)
    public String returnBook(Model model, @ModelAttribute("itemInfo")ItemInfo itemInfo) throws ServiceException {
        itemService.returnBook(itemInfo.getItemID());
        return "redirect:/main";
    }


    @ModelAttribute("itemInfo")
    public ItemInfo getItemInfo() throws ServiceException {
        return new ItemInfo();
    }


    @ModelAttribute("takenBooks")
    public List<TakenBookInfo> getTakenBooks() throws ServiceException {
        return new ArrayList<>();
    }
}
