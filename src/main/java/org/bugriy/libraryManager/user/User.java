package org.bugriy.libraryManager.user;

public class User {
    private int id;
    private String username;
    private String email;

    public User() {}
    public User(final int id, final String username, final String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
