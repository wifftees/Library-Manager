package org.bugriy.libraryManager.book;

public class Book {
    private int id;
    private int userid;
    private String title;
    private String author;

    public Book(){}
    public Book(final int id, final int userid, final String title, final String author) {
        this.id = id;
        this.userid = userid;
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(final int userid) {
        this.userid = userid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }
}
