package org.bugriy.libraryManager.person;

import org.bugriy.libraryManager.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/people")
public class PersonController {
    private final PersonService personService;
    private final BookService bookService;

    @Autowired
    public PersonController(final PersonService personService, final BookService bookService) {
        this.personService = personService;
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ModelAndView getUser(@PathVariable("id") final int id, final ModelMap model) {
        Optional<Person> person = personService.getPersonById(id);

        if (person.isEmpty()) {
            model.addAttribute("id", id);
            return new ModelAndView("redirect:/people/personNotExist", model);
        }

        model.addAttribute("person", person.get());
        model.addAttribute("books", bookService.getBooksOfPerson(person.get()));
        return new ModelAndView("person/index", model);
    }

    @GetMapping()
    public String index(final Model model) {
        model.addAttribute("people", personService.index());
        return "index";
    }

    @GetMapping("/personNotExist")
    public String personNotExist(@RequestParam("id") final int id, final Model model) {
        model.addAttribute("id", id);
        return "person/notExist";
    }
}
