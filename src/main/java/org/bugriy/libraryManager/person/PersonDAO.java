package org.bugriy.libraryManager.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Optional<Person> optionalQuery(List<Person> list) {
        return list.stream().findAny();
    }

    public Optional<Person> getPersonById(final int id) {
        return optionalQuery(
                jdbcTemplate.query("SELECT * FROM user_ WHERE id=?",
                        new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
        );
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM user_", new BeanPropertyRowMapper<>(Person.class));
    }

    public Optional<Person> getPersonByUsername(final String username) {
        return optionalQuery(
                jdbcTemplate.query("SELECT * FROM user_ WHERE username=?",
                        new Object[]{username}, new BeanPropertyRowMapper<>(Person.class))
        );
    }
}
