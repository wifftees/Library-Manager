package org.bugriy.libraryManager.book;


import org.bugriy.libraryManager.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/order")
    public ModelAndView getOrderForm(@RequestParam("id") final int id, final ModelMap modelMap) {
        Optional<Book> book = bookService.getBookById(id);

        if (book.isEmpty()) {
            modelMap.addAttribute("id", id);
            return new ModelAndView("redirect:/book/notExist", modelMap);
        }

        modelMap.addAttribute("book", book.get());

        return new ModelAndView("book/order", modelMap);
    }

    @GetMapping()
    public String getBooks(final Model model) {
        List<Book> books = bookService.getAvailableBooks();
        System.out.println(books.get(0));
        model.addAttribute("books", books);
        return "book/index";
    }
}
