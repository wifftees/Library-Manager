package org.bugriy.libraryManager.book;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    public BookDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooksByPersonId(final int id) {
        return jdbcTemplate.query("SELECT id, userid as userId, title, author FROM book_ WHERE userid=?",
                new BeanPropertyRowMapper<>(Book.class), id);
    }

    public List<Book> getBooksWithoutUserId() {
        return jdbcTemplate.query("SELECT * FROM book_ WHERE userid is null",
                new BeanPropertyRowMapper<>(Book.class));
    }
}
