package org.bugriy.libraryManager.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    // mock database
    public static final List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "Test", "test@gmail.com"));
    }
    public User getUserById(final int id) {
        return users.get(0);
    }

    public List<User> index() {
        return users;
    }
}
