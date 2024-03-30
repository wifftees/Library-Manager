package org.bugriy.libraryManager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getUserById(final int id) {
        return userDAO.getUserById(id);
    }

    public List<User> index() {
        return userDAO.index();
    }
}
