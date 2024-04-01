//package org.bugriy.libraryManager.person.security;
//
//import org.bugriy.libraryManager.person.Person;
//import org.bugriy.libraryManager.person.PersonDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class PersonDetailsService implements UserDetailsService {
//    private final PersonDAO personDAO;
//
//    @Autowired
//    public PersonDetailsService(PersonDAO personDAO) {
//        this.personDAO = personDAO;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Person> person = personDAO.getPersonByUsername(username);
//
//        if (person.isEmpty()) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        return new PersonDetails(person.get());
//    }
//}
