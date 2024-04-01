package org.bugriy.libraryManager.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonService {
    private final PersonDAO personDAO;

    @Autowired
    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public Person getUserById(final int id) {
        return personDAO.getUserById(id);
    }

    public List<Person> index() {
        return personDAO.index();
    }
}
