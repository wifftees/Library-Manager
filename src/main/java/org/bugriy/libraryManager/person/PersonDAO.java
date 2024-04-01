package org.bugriy.libraryManager.person;

import org.bugriy.libraryManager.util.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;
    private final QueryHandler<Person> queryHandler;


    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate, final QueryHandler<Person> queryHandler) {
        this.jdbcTemplate = jdbcTemplate;
        this.queryHandler = queryHandler;
    }


    public Optional<Person> getPersonById(final int id) {
        return queryHandler.optionalQuery(
                jdbcTemplate.query("SELECT id, username, email FROM user_ WHERE id=?",
                        new BeanPropertyRowMapper<>(Person.class), id)
        );
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT id, username, email FROM user_", new BeanPropertyRowMapper<>(Person.class));
    }

    public Optional<Person> getPersonByUsername(final String username) {
        return queryHandler.optionalQuery(
                jdbcTemplate.query("SELECT * FROM user_ WHERE username=?",
                        new Object[]{username}, new BeanPropertyRowMapper<>(Person.class))
        );
    }
}
