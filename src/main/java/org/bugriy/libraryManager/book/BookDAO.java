package org.bugriy.libraryManager.book;

import org.bugriy.libraryManager.util.QueryHandler;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;
    private final QueryHandler<Book> queryHandler;

    public BookDAO(final JdbcTemplate jdbcTemplate, final QueryHandler<Book> queryHandler) {
        this.jdbcTemplate = jdbcTemplate;
        this.queryHandler = queryHandler;
    }

    public List<Book> getBooksByPersonId(final int id) {
        return jdbcTemplate.query("SELECT id, userid as userId, title, author FROM book_ WHERE userid=?",
                new BeanPropertyRowMapper<>(Book.class), id);
    }

    public List<Book> getBooksWithoutUserId() {
        return jdbcTemplate.query(
                "SELECT id, userid as userId, title, author FROM book_ WHERE userid IS NULL",
                (rs, rowNum) -> new Book(rs.getInt("id"), rs.getInt("userid"), rs.getString("title"), rs.getString("author"))
        );
    }

    public Optional<Book> getBookById(final int id) {
        return queryHandler.optionalQuery(
        jdbcTemplate.query(
                "SELECT id, userid as userId, title, author FROM book_ WHERE id=?",
                (rs, rowNum) -> new Book(rs.getInt("id"), rs.getInt("userid"), rs.getString("title"), rs.getString("author")), id
        ));
    }
}
