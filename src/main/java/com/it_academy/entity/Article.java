package com.it_academy.entity;

import java.util.ArrayList;
import java.util.List;

public class Article {
    private String articleID;
    private String title;
    private String author;
    private String url;
    List<Hotkeys> hotkeys;

    public Article() {
        this.hotkeys = new ArrayList<Hotkeys>();
    }

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Hotkeys> getHotkeys() {
        return hotkeys;
    }

    public void setHotkeys(List<Hotkeys> hotkeys) {
        this.hotkeys = hotkeys;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleID='" + articleID + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", hotkeys=" + hotkeys +
                '}';
    }
}