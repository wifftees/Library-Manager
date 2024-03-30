package org.bugriy.libraryManager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") final int id, final Model model) {
        userService.getUserById(id);
        return "user/index";
    }

    @GetMapping()
    public String index(final Model model) {
        model.addAttribute("users", userService.index());
        return "user/index";
    }
}
