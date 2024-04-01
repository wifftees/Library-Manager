package org.bugriy.libraryManager.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonService {
    private final PersonDAO personDAO;

    @Autowired
    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public Optional<Person> getPersonById(final int id) {
        return personDAO.getPersonById(id);
    }

    public List<Person> index() {
        return personDAO.index();
    }
}
