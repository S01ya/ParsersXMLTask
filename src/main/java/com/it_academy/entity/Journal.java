package com.it_academy.entity;

import java.util.ArrayList;
import java.util.List;

public class Journal {
    private String title;
    private Contacts contacts;
    private List<Article> article;

    public Journal(String title, Contacts contacts, ArrayList<Article> article) {
        this.title = title;
        this.contacts = new Contacts();
        this.article = new ArrayList<Article>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "title='" + title + '\'' +
                ", contacts=" + contacts +
                ", article=" + article +
                '}';
    }
}
