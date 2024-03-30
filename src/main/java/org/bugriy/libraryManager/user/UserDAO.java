package org.bugriy.libraryManager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User getUserById(final int id) {
        // return users.get(0);
        return null;
    }

    public List<User> index() {
        return jdbcTemplate.query("SELECT * FROM user_", new BeanPropertyRowMapper<>(User.class));
    }
}
