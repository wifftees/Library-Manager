package org.bugriy.libraryManager.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") final int id, final Model model) {
        personService.getUserById(id);
        return "person/index";
    }

    @GetMapping()
    public String index(final Model model) {
        model.addAttribute("people", personService.index());
        return "person/index";
    }
}
