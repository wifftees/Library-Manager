package org.bugriy.libraryManager.util;

import org.bugriy.libraryManager.person.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class QueryHandler<T> {
    public Optional<T> optionalQuery(List<T> list) {
        return list.stream().findAny();
    }
}
