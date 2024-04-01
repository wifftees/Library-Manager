package org.bugriy.libraryManager.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Person getUserById(final int id) {
        // return users.get(0);
        return null;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM user_", new BeanPropertyRowMapper<>(Person.class));
    }
}
