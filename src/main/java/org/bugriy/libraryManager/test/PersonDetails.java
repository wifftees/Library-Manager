//package org.bugriy.libraryManager.person.security;
//
//import org.bugriy.libraryManager.person.Person;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//
//@Component
//public class PersonDetails implements UserDetails {
//    private final Person person;
//
//    @Autowired
//    public PersonDetails(Person person) {
//        this.person = person;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return person.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return person.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//
//    public Person getPerson() {
//        return person;
//    }
//}
