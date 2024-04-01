package org.bugriy.libraryManager.book;

import org.bugriy.libraryManager.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookDAO bookDAO;

    @Autowired
    public BookService(final BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> getBooksOfPerson(final Person person) {
        return bookDAO.getBooksByPersonId(person.getId());
    }

    public List<Book> getAvailableBooks() {
        return bookDAO.getBooksWithoutUserId();
    }

    public Optional<Book> getBookById(final int id) {
        return bookDAO.getBookById(id);
    }

}
